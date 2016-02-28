package ru.itis.inform;

import ru.itis.inform.linkedList.Iterator;
import ru.itis.inform.linkedList.LinkedList;

/**
 * Created by acacuce on 28.02.16.
 */
public class HumanSort {
    private  ArrayList<LinkedList<Human>> arrayList;
    public LinkedList<Human> sort (LinkedList<Human> listOfHuman){
        this.arrayList = new ArrayList<LinkedList<Human>>();
        Iterator<Human> iterator = listOfHuman.iterator();
        while (iterator.hasNext()) {
            Human currentHuman = iterator.next();
            int age = currentHuman.getAge();
            LinkedList slotOfArrayList = arrayList.get(age);
            if (slotOfArrayList != null) {
                slotOfArrayList.add(currentHuman);
            } else {
                LinkedList<Human> list = new LinkedList<Human>();
                list.add(currentHuman);
                arrayList.set(list, age);

            }
        }
        LinkedList<Human> sortedList = buildList();
        return sortedList;
    }

    private LinkedList<Human> buildList () {
        LinkedList<Human> buildedList = new LinkedList<Human>();
        for (int i =0; i < arrayList.getSizeOfArray(); i++) {
            LinkedList<Human> currentList = arrayList.get(i);
            if (currentList != null ) {
                if (buildedList.getHead() == null ){
                    buildedList = currentList;
                } else {
                    buildedList.getTail().setNext(currentList.getHead());
                    buildedList.setTail(currentList.getTail());
                }
            }
        }
        return buildedList;
    }

}
