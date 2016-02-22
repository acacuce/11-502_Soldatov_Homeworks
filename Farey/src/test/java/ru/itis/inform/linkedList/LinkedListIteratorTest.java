package ru.itis.inform.linkedList;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by acacuce on 22.02.16.
 */
public class LinkedListIteratorTest extends TestCase {
    private LinkedList<Integer> testList;
    private Iterator<Integer> testIterator;

    @Before
    public void setUp() throws Exception {
        this.testList = new LinkedList<Integer>();
        for (int i = 0; i < 8; i++) {
            testList.add(i);
        }
        this.testIterator = testList.iterator();
    }

    @Test
    public void testHasNext() throws Exception {
        assertTrue(testIterator.hasNext());
        for (int i = 0; i < 8; i++) {
            testIterator.next();
        }
        assertFalse(testIterator.hasNext());
    }

    @Test
    public void testNext() throws Exception {
        assertEquals((Integer) 0, testIterator.next());
        assertEquals((Integer) 1, testIterator.next());
    }

    @Test
    public void testPrevious() throws Exception {
        try {
            testIterator.previous();
        } catch (NullPointerException e) {
            assertEquals("Exeption", "Exeption");
        }
        assertEquals(testIterator.next(), (Integer) 0);
        assertEquals((Integer) 1, testIterator.previous());
    }

    @Test
    public void testInsert() throws Exception {
        assertEquals((Integer) 0, testIterator.next());
        testIterator.insert(42);
        assertEquals(testIterator.peekPrevious(), (Integer) 42);
    }
}