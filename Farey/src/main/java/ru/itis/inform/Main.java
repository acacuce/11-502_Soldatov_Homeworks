package ru.itis.inform;

/**
 * Created by acacuce on 15.02.16.
 */
public class Main {
    public static void main (String [] args) {
        IFareySequenceGenerator firstSeries = new FareySequenceGeneratorOnLinkedList();
        IFareySequenceGenerator secondSeries = new FareySequenceGeneratorArrayImpl();
        firstSeries.runFarey(5);
        secondSeries.runFarey(5);
        firstSeries.showSeries();
        System.out.println();
        secondSeries.showSeries();

    }
}
