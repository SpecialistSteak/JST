package specialiststeak.TimeUtils;

public interface TimedCode {
    /**
     * Runs a piece of code and returns the time it took to run in nanoseconds
     *
     * @param code The code to run
     * @return The time it took to run in nanoseconds
     */
    public static long runCode(Runnable code) {
        long startTime = System.nanoTime();
        code.run();
        long endTime = System.nanoTime();
        return (endTime - startTime);
    }

    /**
     * Runs a piece of code and adds the time it took to run to the TimeTester object
     *
     * @param code The code to run
     */
    public static void timerRunCode(Runnable code) {
        long startTime = System.nanoTime();
        code.run();
        long endTime = System.nanoTime();
    }
}
