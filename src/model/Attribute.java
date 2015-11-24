package model;

/**
 * Created by Gabriel on 24/11/2015.
 */
public interface Attribute<S, T> {
    T get(S item);
}
