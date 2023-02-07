package specialiststeak.memoryutils.CSV;

import org.jfree.data.xy.XYSeries;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVToGraph {

    /**
     * Converts a CSV file to a graph. The image will be saved to the root directory of where it's run from.
     *
     * @throws FileNotFoundException If the CSV file is not found
     */
    public static void convertToGraph() throws FileNotFoundException {
        convertToGraph("memory_points.csv", "memory_points.png", ChartType.STEP);
    }

    /**
     * Converts a CSV file to a graph. The image will be saved to the same directory as the CSV file.
     *
     * @param filePathToCSV The path to the CSV file
     * @throws FileNotFoundException If the CSV file is not found
     */
    public static void convertToGraph(String filePathToCSV) throws FileNotFoundException {
        convertToGraph(filePathToCSV, String.format("%s.png", filePathToCSV.split("\\.")[0]), ChartType.STEP);
    }

    /**
     * Converts a CSV file to a graph
     *
     * @param filePath  The path to the CSV file
     * @param imagePath The path to the image file to save the graph to
     * @param CH        The chart type to use
     * @throws FileNotFoundException If the CSV file is not found
     */
    public static void convertToGraph(String filePath, String imagePath, ChartType CH) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filePath));

        // Skip the header row
        sc.nextLine();

        // Create a new XYSeries for storing the data
        XYSeries series = new XYSeries("Memory Usage");

        // Read the CSV file and add the data to the XYSeries
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] values = line.split(",");

            try {
                int lineNum = Integer.parseInt(values[0].trim());
                double memoryPercentage = Double.parseDouble(values[1].trim());
                series.add(lineNum, memoryPercentage);
            } catch (NumberFormatException e) {
                System.out.println("Skipping line with invalid data: " + line);
            }
        }
        CH.makeChart(imagePath, series);
    }
}