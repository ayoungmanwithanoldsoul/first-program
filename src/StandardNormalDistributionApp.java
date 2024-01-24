import org.apache.commons.math3.distribution.NormalDistribution;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class StandardNormalDistributionApp extends JFrame {

    private StandardNormalDistributionApp() {
        setTitle("Standard Normal Distribution");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        JFreeChart chart = createChart();
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel, BorderLayout.CENTER);

        getContentPane().add(panel);
        pack();
        setLocationRelativeTo(null);
    }

    private JFreeChart createChart() {
        DefaultXYDataset dataset = new DefaultXYDataset();

        double[][] data = generateChartData();
        dataset.addSeries("Standard Normal Distribution", data);

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Standard Normal Distribution",
                "Z-Score",
                "Probability",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        return chart;
    }

    private double[][] generateChartData() {
        double[][] data = new double[2][101];
        NormalDistribution distribution = new NormalDistribution();

        NumberFormat format = new DecimalFormat("0.00");
        for (int i = 0; i <= 100; i++) {
            double z = -3.0 + i * 0.06;
            data[0][i] = z;
            data[1][i] = distribution.cumulativeProbability(z);
        }

        return data;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StandardNormalDistributionApp().setVisible(true));
    }
}
