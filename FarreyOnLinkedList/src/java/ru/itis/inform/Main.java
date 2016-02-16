package ru.itis.inform;

/**
 * Created by acacuce on 15.02.16.
 */
public class Main {
    public static void main (String [] args) {
        FareySequenceGeneratorOnLinkedList newSeries = new FareySequenceGeneratorOnLinkedList(5);
        newSeries.generateSeries();
        newSeries.showSeries();
    }
}
