package application;

import model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Gabriel on 20/10/2015.
 */
public class HistogramDisplay<T> extends ApplicationFrame {

    private Histogram<T> histogram = new Histogram<>();
    private String axisName;

    public HistogramDisplay(Histogram<T> histogram, String axisName) {
        super("Histogram");
        this.histogram = histogram;
        this.axisName = axisName;
        setContentPane(createPanel());
        pack();
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500, 500));
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        return ChartFactory.createBarChart("Histogram", axisName, "Number of accounts", dataset);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        for (T key : histogram.keySet()) {
            defaultCategoryDataset.addValue(histogram.get(key), "", (Comparable) key);
        }
        return defaultCategoryDataset;
    }
}
