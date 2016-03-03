package ru.itis.inform;

import org.junit.Test;
import ru.itis.inform.Human;
import static org.junit.Assert.*;

/**
 * Created by acacuce on 24.02.16.
 */
public class HumanTest
{
    private Human testHuman;
    @org.junit.Before
    public void setUp() throws Exception {
        this.testHuman = new Human("Nikita", 12);
    }

    @Test
    public void testToString() throws Exception {
        String expectedString = "Nikita 12";
        String actualString = testHuman.toString();
        assertEquals(expectedString, actualString);
    }

    @Test
    public void testGetAge() throws Exception {
        int expectedAge = 12;
        int actualAge = testHuman.getAge();
        assertEquals(expectedAge, actualAge);
    }

    @Test
    public void testGetName() throws Exception {
        String expectedName = "Nikita";
        String actualName = testHuman.getName();
        assertEquals(expectedName,actualName);
    }
}