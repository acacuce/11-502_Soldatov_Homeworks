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

    public void testAdd() throws Exception {
        LinkedList<Integer> list = new LinkedList<Integer>();

    }

    @Test
    public void testRemove() throws Exception {
       testList.remove(5);
        while (iterator.hasNext()) {
            assertNotEquals(iterator.next(),(Integer) 5);
        }
    }

    public void testAppend() throws Exception {
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
        actualList.append(expectedList);
        secondActualList.append(toBeAdded);
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

    public void testMerge() throws Exception {
        LinkedList<Integer> firstList = new  LinkedList<Integer>();
        LinkedList<Integer> secondList = new  LinkedList<Integer>();
        LinkedList<Integer> expectedList = new  LinkedList<Integer>();
        firstList.add(1);
        firstList.add(3);
        firstList.add(5);
        firstList.show();
        secondList.add(2);
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        expectedList.add(5);
        LinkedList<Integer> merge = LinkedList.merge(firstList, secondList);
        merge.show();
        assertTrue(merge.equals(expectedList));
    }

    public void testMergeSort() throws Exception {
        LinkedList<Integer> testList = new LinkedList<Integer>();
        LinkedList<Integer> expectedList = new LinkedList<Integer>();
        testList.add(2);
        testList.add(10);
        testList.add(23);
        testList.add(1);
        testList.add(0);
        expectedList.add(0);
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(10);
        expectedList.add(23);
        LinkedList<Integer> sortedList = LinkedList.mergeSort(testList);
        assertTrue(expectedList.equals(sortedList));

    }
}