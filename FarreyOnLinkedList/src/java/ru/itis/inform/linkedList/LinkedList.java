package ru.itis.inform.linkedList;

import ru.itis.inform.RationalNum;
import ru.itis.inform.linkedList.List;
import ru.itis.inform.linkedList.Node;
import ru.itis.inform.IRationalNum;

public class LinkedList implements List {
    private Node first;
    private Node tail;

    private int count;

    public LinkedList() {

        this.first = null;
        this.count = 0;
    }

    public void add(IRationalNum element) {
        Node newNode = new Node(element);

        if (first == null) {
            this.first = newNode;
            this.tail = first;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    @Override
    public void remove(IRationalNum element) {
        Node previous = null;
        Node current  = this.first;
        while (current.getValue() != element) {
            previous = current;
            current  = current.getNext();
        }
        if (previous == null){
            this.first = current.getNext();
        }else {
            previous.setNext(current.getNext());
        }
    }

    public void insertElement (Node first, Node second, IRationalNum element) {
        Node newNode = new Node(element);
        first.setNext(newNode);
        newNode.setNext(second);

    }

    public Node getFirst() {
        return first;
    }

}
