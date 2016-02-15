package ru.itis.inform;

/**
 * Created by acacuce on 15.02.16.
 */
public class Main {
    public static void main (String [] args) {
        FareySequenceGeneratorArrayImpl newSeries = new FareySequenceGeneratorArrayImpl (8, 50);
        newSeries.generateSeries();
        newSeries.showSeries();
    }
}
