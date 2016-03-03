package ru.itis.inform.linkedList;

public class Node<T> {

    private T value;
    private Node<T> next;
    private Node<T> previous;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    @Override
    public boolean equals(Object node) {
        if (node == null) return false;
        if (node == this) return true;
        if (!(node instanceof Node)) return false;

        Node anotherNode = (Node) node;
        if (this.value.equals(anotherNode.getValue())) {
            System.out.println(this.value.toString());
            System.out.println(anotherNode.getValue().toString());
            return true;
        }
        return false;
    }
}
