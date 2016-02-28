package ru.itis.inform;

import ru.itis.inform.linkedList.LinkedList;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by acacuce on 24.02.16.
 */
public class Main {
    public static void main(String[] args) {
        String fileNameInput = "/Users/acacuce/javaHomework/HumanSort/src/main/java/ru/itis/inform/Humans";
        String fileNameOut = "/Users/acacuce/javaHomework/HumanSort/src/main/java/ru/itis/inform/HumansOut";

        HumansReaderWriter readerWriter = new HumansReaderWriter();
        HumanSort sort = new HumanSort();
        try {
            LinkedList<Human> list =readerWriter.readHumans(fileNameInput);
             list = sort.sort(list);
            list.show();
            readerWriter.writeHumans(fileNameOut, list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
