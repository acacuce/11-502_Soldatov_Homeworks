package ru.itis.inform;

import ru.itis.inform.linkedList.Iterator;
import ru.itis.inform.linkedList.LinkedList;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by acacuce on 22.02.16.
 */
public class FareySequenceGeneratorOnLinkedListTest extends junit.framework.TestCase {
    private FareySequenceGeneratorOnLinkedList newSeries;

    @org.junit.Before
    public void setUp () throws Exception {
        this.newSeries = new FareySequenceGeneratorOnLinkedList();
    }
    private LinkedList<RationalNum> configureList (){
        LinkedList<RationalNum> list = new LinkedList<RationalNum>();
        list.add(new RationalNum(0, 1));
        list.add(new RationalNum(1, 3));
        list.add(new RationalNum(1, 2));
        list.add(new RationalNum(2, 3));
        list.add(new RationalNum(1, 1));
        return list;
    }

    @org.junit.Test
    public void testRunFarey() throws Exception {
        LinkedList<RationalNum> expectedList = configureList();
        LinkedList<RationalNum> actualList = (LinkedList<RationalNum>) newSeries.runFarey(3);
        Iterator<RationalNum> iteratorForEpected = expectedList.iterator();
        Iterator<RationalNum> iteratorForActual = actualList.iterator();
        while (iteratorForActual.hasNext() && iteratorForEpected.hasNext()) {
            RationalNum expectedNumber = iteratorForEpected.next();
            RationalNum actualNumber = iteratorForActual.next();
            assertEquals(expectedNumber.getNumerator(), actualNumber.getNumerator());
            assertEquals(expectedNumber.getDenominator(), actualNumber.getDenominator());
        }
    }
}