package ru.itis.inform.linkedList;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by acacuce on 22.02.16.
 */
public class LinkedListTest extends TestCase {
    LinkedList<Integer> testList;
    Iterator<Integer> iterator;
    @Before
    public void setUp() throws Exception {
        this.testList = new LinkedList<Integer>();
        for (int i = 0; i < 15; i++){
            testList.add(i);
        }
        this.iterator = testList.iterator();
    }

    @Test
    public void testRemove() throws Exception {
       testList.remove(5);
        while (iterator.hasNext()) {
            assertNotEquals(iterator.next(),(Integer) 5);
        }
    }

    public void testMerge() throws Exception {
        //Test empty
        LinkedList<Integer> expectedList = new LinkedList<Integer>();
        LinkedList<Integer> actualList = new LinkedList<Integer>();
        LinkedList<Integer> secondActualList = new LinkedList<Integer>();
        LinkedList<Integer> toBeAdded = new LinkedList<Integer>();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        secondActualList.add(1);
        toBeAdded.add(2);
        toBeAdded.add(3);
        actualList.merge(expectedList);
        secondActualList.merge(toBeAdded);
        assertTrue(actualList.equals(expectedList));
        assertTrue(secondActualList.equals(expectedList));

    }

    public void testEquals() throws Exception {
        LinkedList<Integer> firstList = new LinkedList<Integer>();
        LinkedList<Integer> secondList = new LinkedList<Integer>();
        firstList.add(1);
        secondList.add(1);
        assertTrue(firstList.equals(secondList));

    }
}