package de.steuer.ttt.api.utils;

/**
 * @author Steuer
 */
public class Duo<I, O> {

    private I first;
    private O second;

    public Duo(I first, O second) {
        this.first = first;
        this.second = second;
    }

    public I getFirst() {
        return first;
    }

    public O getSecond() {
        return second;
    }
}
