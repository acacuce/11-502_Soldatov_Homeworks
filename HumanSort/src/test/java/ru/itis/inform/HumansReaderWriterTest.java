package ru.itis.inform;

import org.junit.Before;
import org.junit.Test;
import ru.itis.inform.linkedList.LinkedList;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by acacuce on 24.02.16.
 */
public class HumansReaderWriterTest {
    LinkedList<Human> expectedList;
    String fileNameInput;
    String fileNameOutput;
    HumansReaderWriter readerWriter;
    @Before
    public void setUp() throws Exception {
        this.fileNameInput ="/Users/acacuce/javaHomework/HumanSort/src/test/java/ru/itis/inform/in";
        this.fileNameOutput = "/Users/acacuce/javaHomework/HumanSort/src/test/java/ru/itis/inform/out";
        readerWriter = new HumansReaderWriter();
    }

//    private LinkedList<Human> configureList (LinkedList<Human> list) {
//    }

    @Test
    public void testReadHumans() throws Exception {
        LinkedList<Human> expectedList = new LinkedList<Human>();
        expectedList.add(new Human("Mat", 30));
        expectedList.add(new Human("Leo", 22));
        LinkedList<Human> actualList = new LinkedList<Human>();
        actualList = readerWriter.readHumans(fileNameInput);
//        assertTrue(actualList.equals(expectedList));
    }

    @Test
    public void testCreateHumanFromString() throws Exception{
        String humanString = "Dave 10";
        Human dave = new Human("Dave", 10);
        assertTrue(readerWriter.createHumanWithParamsFromStr(humanString).equals(dave));
    }

    @Test
    public void testWriteHumans() throws Exception{
        LinkedList<Human> list = new LinkedList<Human>();
        list.add(new Human("Leo", 34));
        list.add(new Human("Max", 43));
        readerWriter.writeHumans(fileNameOutput, list);
        File file = new File(fileNameOutput);
        assertTrue(file.exists());
        LinkedList result = readerWriter.readHumans(fileNameOutput);

//        assertTrue(result.equals(list));

    }
}