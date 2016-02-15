package ru.itis.inform;

public class LinkedList implements List {
    private Node first;

    private int count;

    public LinkedList() {
        this.first = null;
        this.count = 0;
    }

    public void add(int element) {
        Node newNode = new Node(element);

        if (first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(this.first);
            first = newNode;
        }
    }

    @Override
    public void remove(int element) {
        Node previous = null;
        Node current = this.first;
        while (current.getValue() != element) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null){
            this.first = current.getNext();
        }else {
            previous.setNext(current.getNext());
        }
    }

    public void show() {
        Node node = first;

        while(node.getNext() != null) {
            System.out.print(node.getValue() + ", ");
            node = node.getNext();
        }
        System.out.print(node.getValue());
    }
}
