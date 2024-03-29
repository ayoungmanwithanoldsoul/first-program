import java.util.ArrayList;
import java.util.List;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

/**
 * Sine wave with customized series style
 *
 * <p>* Demonstrates the following:
 *
 * <ul>
 *   <li>Customizing the series style properties
 */
public class LineChart02 implements ExampleChart<XYChart> {

    public static void main(String[] args) {

        ExampleChart<XYChart> exampleChart = new LineChart02();
        XYChart chart = exampleChart.getChart();
        new SwingWrapper<>(chart).displayChart();
    }

    @Override
    public XYChart getChart() {

        // Create Chart
        XYChart chart =
                new XYChartBuilder().width(800).height(800).title(getClass().getSimpleName()).build();

        // Customize Chart
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendVisible(false);
        chart.setYAxisGroupTitle(1, "B");

        // generates sine data
        int size = 30;
        List<Integer> xData = new ArrayList<>();
        List<Double> yData = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            double radians = (Math.PI / (size / 3) * i);
            xData.add(i - size / 2);
            yData.add(-.000001 * Math.sin(radians));
        }

        // generates cos data
        List<Integer> xData2 = new ArrayList<>();
        List<Double> yData2 = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            double radians = (Math.PI / (size / 2) * i);
            xData2.add(i - size / 2);
            yData2.add(-.000001 * Math.cos(radians));
        }

        // Series
        //XYSeries series = chart.addSeries("y=sin(x)", xData, yData);
        //series.setLineColor(XChartSeriesColors.PURPLE);
        //series.setLineStyle(SeriesLines.DASH_DASH);
        //series.setMarkerColor(XChartSeriesColors.GREEN);
        //series.setMarker(SeriesMarkers.SQUARE);

        XYSeries series = chart.addSeries("y=cos(x)", xData2, yData2);
        series.setLineColor(XChartSeriesColors.PINK);
        series.setLineWidth(5);
        series.setMarker(SeriesMarkers.NONE);

        return chart;
    }

    @Override
    public String getExampleChartName() {

        return getClass().getSimpleName() + " - Customized Series Style";
    }
}