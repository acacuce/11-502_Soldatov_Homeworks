package ru.itis.inform;

import org.junit.Before;
import org.junit.Test;
import ru.itis.inform.linkedList.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by acacuce on 03.03.16.
 */
public class HumanSortTest {

    HumanSort sort;
    @Before
    public void setUp() throws Exception {
        this.sort = new HumanSort();
    }

    @Test
    public void testSortByAge() throws Exception {
        LinkedList<Human> expected = new LinkedList<Human>();
        LinkedList<Human> actual = new LinkedList<Human>();

        expected.add(new Human("Dave", 11));
        expected.add(new Human("Andre", 20));
        expected.add(new Human("Bob", 40));
        actual.add(new Human("Bob", 40));
        actual.add(new Human("Andre", 20));
        actual.add(new Human("Dave", 11));
        actual = sort.sortByAge(actual);
//        assertTrue(actual.equals(expected));

    }

    @Test
    public void testSortByNameWithRandomLenght() throws Exception {
        LinkedList<Human> expected = new LinkedList<Human>();
        LinkedList<Human> actual = new LinkedList<Human>();
//        java.util.LinkedList<Human> expected = new java.util.LinkedList<Human>();
//        java.util.LinkedList<Human> actual = new java.util.LinkedList<Human>();
        expected.add(new Human("Andre", 20));
        expected.add(new Human("Bob", 40));
        expected.add(new Human("Dave", 11));
        actual.add(new Human("Bob", 40));
        actual.add(new Human("Andre", 20));
        actual.add(new Human("Dave", 11));
        actual = sort.sortByNameWithRandomLength(actual);
//        assertTrue(actual.equals(expected));
    }
}