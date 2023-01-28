package specialiststeak.memoryutils;

import java.util.ArrayList;

public class MemoryTester {
    private final ArrayList<MemoryPoints> memoryUsage;

    public MemoryTester() {
        memoryUsage = new ArrayList<>();
    }

    public static double getUsableFreeMemory() {
        return Runtime.getRuntime().freeMemory();
    }

    //Thanks to Brian_Entei on StackOverflow for this code!

    /**
     * @return The line number of the code that ran this method
     * @author Brian_Entei
     */
    public static int getLineNumber() {
        return ___8drrd3148796d_Xaf();
    }

    /**
     * This methods name is ridiculous on purpose to prevent any other method
     * names in the stack trace from potentially matching this one.
     *
     * @return The line number of the code that called the method that called
     * this method(Should only be called by getLineNumber()).
     * @author Brian_Entei
     */
    private static int ___8drrd3148796d_Xaf() {
        boolean thisOne = false;
        int thisOneCountDown = 1;
        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : elements) {
            String methodName = element.getMethodName();
            int lineNum = element.getLineNumber();
            if (thisOne && (thisOneCountDown == 0)) {
                return lineNum;
            } else if (thisOne) {
                thisOneCountDown--;
            }
            if (methodName.equals("___8drrd3148796d_Xaf")) {
                thisOne = true;
            }
        }
        return -1;
    }

    /**
     * Logs the current memory usage to the memoryUsage ArrayList
     *
     * @param lineNumber the line number of the code that called this method
     */
    public void logUsedMemory(int lineNumber) {
        memoryUsage.add(new MemoryPoints(getUsedMemory() * 100, lineNumber));
    }

    /**
     * Logs the current memory usage to the memoryUsage ArrayList
     */
    public static double getUsedMemory() {
        return (double)
                (Runtime.getRuntime().totalMemory() -
                        Runtime.getRuntime().freeMemory()) /
                Runtime.getRuntime().maxMemory();
    }

    /**
     * Logs the current memory usage to the memoryUsage ArrayList
     */
    public ArrayList<MemoryPoints> getMemoryUsage() {
        return memoryUsage;
    }
}

