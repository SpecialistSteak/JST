package specialiststeak.memoryutils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MemoryTesterToCSV {
    /**
     * Converts a MemoryTester object to a CSV file
     *
     * @param memoryTester The MemoryTester object to convert
     * @param file         The file to write to
     */
    public static void convertToCSV(MemoryTester memoryTester, File file) {
        StringBuilder sb = new StringBuilder();
        sb.append("Line Number, Memory Usage Percentage\n");
        for (MemoryPoints memoryPoint : memoryTester.getMemoryUsage()) {
            sb.append(memoryPoint.getLineNumber()).append(",").append(memoryPoint.getMemoryUsagePercent()).append("\n");
        }
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(sb.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
