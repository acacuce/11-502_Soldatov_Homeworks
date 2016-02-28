package ru.itis.inform;

import java.io.*;

import ru.itis.inform.linkedList.Iterator;
import ru.itis.inform.linkedList.LinkedList;

/**
 * Created by acacuce on 24.02.16.
 */
public class HumansReaderWriter {

    public LinkedList<Human> readHumans (String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (file.exists()) {
            LinkedList<Human> listOfHuman = new LinkedList<Human>();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file.getAbsoluteFile()));
                String currentLine = reader.readLine();
                while (currentLine != null){
                    Human newHuman = createHumanWithParamsFromStr(currentLine);
                    listOfHuman.add(newHuman);
                    currentLine = reader.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return listOfHuman;

        }else throw new FileNotFoundException ();

    }

    public void writeHumans (String fileName, LinkedList<Human> list) {
        File file = new File(fileName);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out =new PrintWriter(file.getAbsoluteFile());
            Iterator<Human> iterator = list.iterator();
            try {
                while (iterator.hasNext()) {
                    out.println(iterator.next().toString());
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Human createHumanWithParamsFromStr (String params) {
        String []atributes = params.split(" ");
        return new Human(Integer.valueOf(atributes[1]), atributes[0]);
    }
}
