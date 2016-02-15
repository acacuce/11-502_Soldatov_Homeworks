package ru.itis.inform;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList myLinkedList = new LinkedList();
        for (int i = 0; i < 16; i++) {
            myLinkedList.add(i);
        }
        myLinkedList.show();
        myLinkedList.remove(15);
        System.out.println();
        myLinkedList.show();
    }
}
