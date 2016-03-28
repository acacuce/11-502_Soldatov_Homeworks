package ru.itis.inform;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by acacuce on 23.03.16.
 */
public class FastHullTest {

    @Test
    public void testBuildHull() throws Exception {
        ArrayList<Point> points = new ArrayList<Point>();
        ArrayList<Point> expected = new ArrayList<Point>();
        points.add(new Point(1, 2));
        points.add(new Point(2, 1));
        points.add(new Point(4, 0));
        points.add(new Point(5, 3));
        points.add(new Point (4 ,7));
        points.add(new Point(4, 4));
        points.add(new Point(3, 2));
        points.add(new Point(2, 3));
        expected.add(new Point(0, 1));
        expected.add(new Point(1, 0));
        expected.add(new Point(0, -1));
        expected.add(new Point(-1, 0));
        FastHull fastHull = new FastHull(points);
        fastHull.buildHull();
        assertTrue(expected.equals(fastHull.getHull()));
    }
}