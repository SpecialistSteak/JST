package specialiststeak.TestingUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class StackTester {
    private final ArrayList<StackElements> stackTrace;

    /**
     * Creates a new StackTester object.
     */
    public StackTester() {
        stackTrace = new ArrayList<StackElements>();
    }

    /**
     * Logs the current stack trace.
     */
    public void logStackTrace(int lineNumber) {
        stackTrace.add(new StackElements(Thread.currentThread().getStackTrace(), lineNumber));
    }

    /**
     * Saves the stack trace to a file.
     *
     * @param file The file to save the stack trace to.
     * @throws IOException If the file cannot be written to.
     */
    public void saveLogToFile(File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (StackElements sb : stackTrace) {
            writer.write(sb.toString());
            writer.write("______________________________________________________\n");
        }
        writer.close();
    }

    /**
     * Prints the stack trace to the console.
     */
    public void printLog() {
        for (StackElements sb : this.stackTrace) {
            System.out.println(sb.toString());
        }
    }

    /**
     * Prints the stack trace to the console.
     */
    public static void printStack() {
        for (StackTraceElement sb : Thread.currentThread().getStackTrace()) {
            System.out.println(sb.toString());
        }
    }

    /**
     * Returns the stack trace as a string.
     *
     * @return The stack trace as a string.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (StackElements se : stackTrace) {
            for (StackTraceElement ste : se.getStackTraceElements()) {
                sb.append(ste).append("\n");
            }
        }
        return sb.toString();
    }
}

class StackElements {
    private final StackTraceElement[] stackTraceElements;
    private final Date currentTime;
    private final int LineNumber;

    /**
     * Creates a new StackElements object.
     *
     * @param stackTraceElements The stack trace elements to store.
     * @param lineNumber         The line number of the log.
     */
    public StackElements(StackTraceElement[] stackTraceElements, int lineNumber) {
        this.stackTraceElements = stackTraceElements;
        LineNumber = lineNumber;
        this.currentTime = new Date();
    }

    /**
     * Returns the stack trace elements.
     *
     * @return The stack trace elements.
     */
    public StackTraceElement[] getStackTraceElements() {
        return stackTraceElements;
    }

    /**
     * Returns the time of the log.
     *
     * @return The time of the log.
     */
    public Date getCurrentTime() {
        return currentTime;
    }

    /**
     * Returns the stack trace elements as a string.
     *
     * @return The stack trace elements as a string.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (StackTraceElement ste : stackTraceElements) {
            result.append(ste.toString()).append("\n");
        }
        result.append("Time of log: ").append(currentTime.toString()).append("\n");
        result.append("Line number: ").append(LineNumber).append("\n");
        return result.toString();
    }
}