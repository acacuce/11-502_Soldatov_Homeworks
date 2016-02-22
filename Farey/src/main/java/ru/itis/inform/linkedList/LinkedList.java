package ru.itis.inform.linkedList;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private Node<T> current;

    class LinkedListIterator implements Iterator<T> {

        public LinkedListIterator(Node<T> head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public boolean hasPrevious() {
            return current.getPrevious() != null;
        }

        @Override
        public T next() {
            T value = current.getValue();
            current = current.getNext();
            return value;
        }

        @Override
        public T previous() {
            if (hasPrevious()) {
                T value = current.getValue();
                current = current.getPrevious();
                return value;
            } else throw new NullPointerException();
        }

        @Override
        public void insert(T element) {
            Node<T> newNode = new Node<T>(element);
            newNode.setNext(current);
            newNode.setPrevious(current.getPrevious());
            current.getPrevious().setNext(newNode);
            current.setPrevious(newNode);

        }

        public Node<T> getCurrent() {
            return current;
        }

        @Override
        public T peekNext() {
            return current.getNext().getValue();
        }

        @Override
        public T peekPrevious() {
            if (current.getPrevious() != null) {
                return current.getPrevious().getValue();
            } else return null;
        }
    }

    public LinkedList() {this.head = null;}

    public void add(T element) {
        Node<T> newNode = new Node<T>(element);

        if (head == null) {
            this.head = newNode;
            this.tail = head;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
    }

    @Override
    public void remove(T element) {
        Node<T> previous = null;
        Node<T> current  = this.head;
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

    public LinkedListIterator iterator () {
        return new LinkedListIterator(head);
    }


    public Node getHead() {
        return head;
    }

}
