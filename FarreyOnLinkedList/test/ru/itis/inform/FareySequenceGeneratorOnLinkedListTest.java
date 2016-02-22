package ru.itis.inform;

import junit.framework.TestCase;

import static org.junit.Assert.*;

/**
 * Created by acacuce on 19.02.16.
 */
public class FareySequenceGeneratorOnLinkedListTest extends TestCase {
    private FareySequenceGeneratorOnLinkedList series;

    @org.junit.Before
    public void setUp () throws Exception {
        this.series = new FareySequenceGeneratorOnLinkedList(6);
    }

    @org.junit.Test
    public void testSeries () throws Exception {
        IRationalNum [] actual = series.generateSeries();

        IRationalNum [] expected =
    }
}