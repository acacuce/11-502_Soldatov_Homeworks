package ru.itis.inform;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by acacuce on 21.03.16.
 */
public class MBOTest {

    @Test
    public void testBuildMBO() throws Exception {
        ArrayList<Point> points = new ArrayList<Point>();
        ArrayList<Point> expected = new ArrayList<Point>();
        points.add(new Point(-1, 0));
        points.add(new Point(0, 0));
        points.add(new Point(0, 1));
        points.add(new Point(0, -1));
        points.add(new Point(1, 0));
        expected.add(new Point(1, 0));
        expected.add(new Point(0, 1));
        expected.add(new Point(-1, 0));
        expected.add(new Point(0, -1));
        MBO mbo = new MBO(points);
        mbo.buildMBO();
        assertTrue(mbo.getMBO().equals(expected));




    }
}