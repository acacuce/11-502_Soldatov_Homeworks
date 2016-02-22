package ru.itis.inform.linkedList;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

}