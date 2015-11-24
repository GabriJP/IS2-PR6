package model;

import java.util.List;

/**
 * Created by Gabriel on 27/10/2015.
 */
public class HistogramBuilder<T> {

    private final List<T> items;

    public HistogramBuilder(List<T> items) {
        this.items = items;
    }

    public <A> Histogram<A> build(Attribute<T, A> content) {
        Histogram<A> histogram = new Histogram<>();
        for (T item : items) {
            A value = content.get(item);
            histogram.increment(value);
        }
        return histogram;
    }
}
