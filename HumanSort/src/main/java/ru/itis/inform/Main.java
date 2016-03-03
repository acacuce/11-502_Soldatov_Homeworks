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
            LinkedList<Integer> test = new LinkedList<Integer>();
            test.add(1);
            System.out.print(list.equals(test));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
