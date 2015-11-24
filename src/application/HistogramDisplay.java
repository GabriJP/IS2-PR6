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

    public HistogramDisplay(Histogram<T> histogram) {
        super("Histogram");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(700, 700));
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        return ChartFactory.createBarChart("Histogram", "Domain", "Number of accounts", dataset);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset defaultCategoryDataset = new DefaultCategoryDataset();
        for (T key : histogram.keySet()) {
            defaultCategoryDataset.addValue(histogram.get(key), "", (Comparable) key);
        }
        return defaultCategoryDataset;
    }
}
