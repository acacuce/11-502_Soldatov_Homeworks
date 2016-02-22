package ru.itis.inform.linkedList;

import ru.itis.inform.IRationalNum;

public class LinkedList implements List {
    private Node head;
    private Node tail;

    private int count;

    public LinkedList() {

        this.head = null;
        this.count = 0;
    }

    public void add(IRationalNum element) {
        Node newNode = new Node(element);

        if (head == null) {
            this.head = newNode;
            this.tail = head;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    @Override
    public void remove(IRationalNum element) {
        Node previous = null;
        Node current  = this.head;
        while (current.getValue() != element) {
            previous = current;
            current  = current.getNext();
        }
        if (previous == null){
            this.head = current.getNext();
        }else {
            previous.setNext(current.getNext());
        }
    }

    public void insertElement (Node first, Node second, IRationalNum element) {
        Node newNode = new Node(element);
        first.setNext(newNode);
        newNode.setNext(second);

    }

    public Node getHead() {
        return head;
    }

}
