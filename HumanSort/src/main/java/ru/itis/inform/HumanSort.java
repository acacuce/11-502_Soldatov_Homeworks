package ru.itis.inform;

import ru.itis.inform.arrayList.ArrayList;
import ru.itis.inform.linkedList.Iterator;
import ru.itis.inform.linkedList.LinkedList;

/**
 * Created by acacuce on 28.02.16.
 */
public class HumanSort {
    private ArrayList<LinkedList<Human>> arrayList;

    public LinkedList<Human> sortByAge(LinkedList<Human> listOfHuman) {
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
        return buildList();
    }

//    public LinkedList<Human> sortByName (LinkedList<Human> listOfHuman){
//        Human human = listOfHuman.getHead().getValue();
//        int lenghtOfNames = human.getName().length();
//        for (int i = lenghtOfNames - 1; i >= 0; i --) {
//            this.arrayList = new ArrayList<LinkedList<Human>>(200);
//            Iterator<Human> iterator = listOfHuman.iterator();
//            while (iterator.hasNext()) {
//                Human currentHuman = iterator.next();
//                Character charAtIndex = currentHuman.getName().charAt(i);
//                LinkedList<Human> listAtIndex = arrayList.get(charAtIndex.hashCode());
//                if (listAtIndex != null){
//                    listAtIndex.add(currentHuman);
//                }else {
//                    listAtIndex = new LinkedList<Human>();
//                    listAtIndex.add(currentHuman);
//                    arrayList.set(listAtIndex, charAtIndex.hashCode());
//                }
//
//            }
//            listOfHuman = buildList();
//        }
//        return listOfHuman;
//    }

    public LinkedList<Human> sortByNameWithRandomLength(LinkedList<Human> listOfHuman) {
        int maxLenghtOfName = findMaxLenght(listOfHuman);
        for (int i = maxLenghtOfName - 1; i >= 0; i --) {
            this.arrayList = new ArrayList<LinkedList<Human>>(200);
            Iterator<Human> iterator = listOfHuman.iterator();
            while (iterator.hasNext()) {
                Human currentHuman = iterator.next();
                if (currentHuman.getName().length() <= i) {
                    LinkedList<Human> listWithNullChar = arrayList.get(0);
                    if (listWithNullChar != null) {
                        listWithNullChar.add(currentHuman);
                    } else {
                        listWithNullChar = new LinkedList<Human>();
                        listWithNullChar.add(currentHuman);
                        arrayList.set(listWithNullChar, 0);
                    }
                } else {
                    Character charAtIndex = currentHuman.getName().charAt(i);
                    LinkedList<Human> listAtIndex = arrayList.get(charAtIndex.hashCode());
                    if (listAtIndex != null) {
                        listAtIndex.add(currentHuman);
                    } else {
                        listAtIndex = new LinkedList<Human>();
                        listAtIndex.add(currentHuman);
                        arrayList.set(listAtIndex, charAtIndex.hashCode());
                    }
                }

            }
            listOfHuman = buildList();
        }
        return listOfHuman;
    }

    private int findMaxLenght (LinkedList<Human> list) {
        Iterator<Human> humanIterator = list.iterator();
        int maxLenghtOfName = 0;
        while (humanIterator.hasNext()){
            String currentName = humanIterator.next().getName();
            if(maxLenghtOfName < currentName.length()) {
                maxLenghtOfName = currentName.length();
            }
        }
        return maxLenghtOfName;
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
