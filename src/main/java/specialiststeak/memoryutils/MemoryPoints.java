package specialiststeak.memoryutils;

/**
 * A class that stores the memory usage and the line number of the code that is currently running
 * This will be used to graph the memory usage of the program
 */
public class MemoryPoints {
    double memoryUsagePercent;
    int lineNumber;

    /**
     * Creates a new MemoryPoints object
     *
     * @param memoryUsage the memory usage of the program
     * @param lineNumber  the line that the memory usage was taken at
     */
    public MemoryPoints(double memoryUsage, int lineNumber) {
        this.memoryUsagePercent = memoryUsage;
        this.lineNumber = lineNumber;
    }

    /**
     * Gets the memory usage of the program
     *
     * @return the memory usage of the program
     */
    public double getMemoryUsagePercent() {
        return memoryUsagePercent;
    }

    /**
     * Sets the memory usage of the program
     *
     * @param memoryUsagePercent the memory usage of the program
     */
    public void setMemoryUsagePercent(double memoryUsagePercent) {
        this.memoryUsagePercent = memoryUsagePercent;
    }

    /**
     * @return the line number of the code that the memory usage was taken at
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * Sets the line number of the object
     *
     * @param lineNumber the line number of the code that the memory usage was taken at
     */
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * toString method
     *
     * @return a string representation of the object
     */
    public String toString() {
        return "MemoryPoints{" +
                "memoryUsagePercent=" + memoryUsagePercent + "%" +
                ", lineNumber=" + lineNumber +
                '}';
    }
}
