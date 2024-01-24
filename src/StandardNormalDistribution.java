import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.colors.XChartSeriesColors;

import java.util.Scanner;

public class StandardNormalDistribution {
    public static double calculateZScore(double x, double mean, double stdDev) {
        return (x - mean) / stdDev;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double mean = 0; // Replace with the desired mean
        double stdDev = 1; // Replace with the desired standard deviation

        System.out.print("Enter the raw score: ");
        double xRaw = scanner.nextDouble();
        double zScore = calculateZScore(xRaw, mean, stdDev);

        System.out.println("Z-Score: " + zScore);

        // Create the line graph
        XYChart chart = new XYChartBuilder()
                .width(800)
                .height(600)
                .title("Standard Normal Distribution")
                .xAxisTitle("Z-Score")
                .yAxisTitle("Probability Density")
                .build();

        // Add a line series representing the standard normal distribution
        double[] xData = {-5, -4.9, -4.8,4.8, 4.9, 5}; // Array of x values
        double[] yData = {0.000001, 0.000002, 0.000003, 0.000003, 0.000002, 0.000001}; // Corresponding y values
        XYSeries series = chart.addSeries("Standard Normal Distribution", xData, yData);
        series.setLineColor(XChartSeriesColors.BLUE);

        // Display the line for the Z-score value
        chart.addSeries("Z-Score", new double[]{zScore, zScore}, new double[]{0, 0.45})
                .setLineColor(XChartSeriesColors.RED);

        // Customize the plot
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Display the line graph using SwingWrapper
        new SwingWrapper<>(chart).displayChart();

        scanner.close();
    }
}
