package ru.itis.inform;

import ru.itis.inform.linkedList.LinkedList;

import java.io.FileNotFoundException;

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
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.add(1);
            LinkedList<Human> list2 = readerWriter.readHumans(fileNameInput);
            list2 = sort.sortByAge(list2);
            readerWriter.writeHumans(fileNameOut, list2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
