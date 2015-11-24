package model;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Gabriel on 20/10/2015.
 */
public class Histogram<T> {

    private final HashMap<T, Integer> map = new HashMap<>();

    public Set<T> keySet() {
        return map.keySet();
    }

    public Integer get(T key) {
        return map.get(key);
    }

    public void increment(T key) {
        map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
    }
}
