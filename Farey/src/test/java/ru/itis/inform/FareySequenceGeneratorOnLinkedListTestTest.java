package ru.itis.inform;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by acacuce on 22.02.16.
 */
public class FareySequenceGeneratorOnLinkedListTestTest {
    private FareySequenceGeneratorArrayImpl series;
    @Before
    public void setUp() throws Exception {
        this.series = new FareySequenceGeneratorArrayImpl();
    }

    private RationalNum [] configureArray () {
        RationalNum testArray [] = new RationalNum[100];
        testArray [0] = new RationalNum(0, 1);
        testArray [1] = new RationalNum(1, 3);
        testArray [2] = new RationalNum(1, 2);
        testArray [3] = new RationalNum(2, 3);
        testArray [4] = new RationalNum(1, 1);
        return testArray;
    }

    @Test
    public void testTestRunFarey() throws Exception {
        RationalNum [] expexctedArray = configureArray();
        RationalNum [] actualArray = series.runFarey(3);
        for (int i = 0; i < 5; i++){
            assertEquals(expexctedArray[i].getNumerator(), actualArray[i].getNumerator());
            assertEquals(expexctedArray[i].getDenominator(), actualArray[i].getDenominator());
        }
    }

}