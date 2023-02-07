package specialiststeak.memoryutils.CSV;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;

public enum ChartType {
    LINE,
    BAR,
    STEP;

    /**
     * Creates a chart from the given XYSeries and saves it to the given image path
     *
     * @param imagePath The path to the image file to save the chart to
     * @param series    The XYSeries to use for the chart
     */
    public void makeChart(String imagePath, XYSeries series) {
        switch (this) {
            case LINE -> {
                XYSeriesCollection dataset = new XYSeriesCollection();
                dataset.addSeries(series);

                JFreeChart chart = ChartFactory.createXYLineChart("Memory Usage Chart", "Line Number", "Memory Usage Percentage", dataset);

                try {
                    ChartUtilities.saveChartAsPNG(new File(imagePath), chart, 800, 600);
                } catch (Exception e) {
                    System.out.println("Error saving the chart as an image: " + e.getMessage());
                }
            }
            case BAR -> {
                XYSeriesCollection dataset = new XYSeriesCollection();
                dataset.addSeries(series);

                JFreeChart chart = ChartFactory.createXYBarChart("Memory Usage Chart", "Line Number", false, "Memory Usage Percentage", dataset);

                try {
                    ChartUtilities.saveChartAsPNG(new File(imagePath), chart, 800, 600);
                } catch (Exception e) {
                    System.out.println("Error saving the chart as an image: " + e.getMessage());
                }
            }
            case STEP -> {
                XYSeriesCollection dataset = new XYSeriesCollection();
                dataset.addSeries(series);

                JFreeChart chart = ChartFactory.createXYStepChart("Memory Usage Chart", "Line Number", "Memory Usage Percentage", dataset, org.jfree.chart.plot.PlotOrientation.VERTICAL, true, true, false);

                try {
                    ChartUtilities.saveChartAsPNG(new File(imagePath), chart, 800, 600);
                } catch (Exception e) {
                    System.out.println("Error saving the chart as an image: " + e.getMessage());
                }
            }
        }
    }
}
