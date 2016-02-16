package ru.itis.inform.linkedList;

import ru.itis.inform.IRationalNum;

public class Node {

    private IRationalNum value;
    private Node next;

    public Node(IRationalNum value) {
        this.value = value;
        this.next = null;
    }

    public void setNext(Node next) {
        this.next  = next;
    }

    public IRationalNum getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}
