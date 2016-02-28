package ru.itis.inform.linkedList;

public class LinkedList<T> implements List<T> {
    private Node<T> head;
    private Node<T> tail;
    private Node<T> current;
    private int count;

    class LinkedListIterator implements Iterator<T> {

        public LinkedListIterator(Node<T> head) {
            current = head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public boolean hasPrevious() {
            return current.getPrevious() != null;
        }

        public T next() {
            T value = current.getValue();
            current = current.getNext();
            return value;
        }

        public T previous() {
            if (hasPrevious()) {
                T value = current.getValue();
                current = current.getPrevious();
                return value;
            } else throw new NullPointerException();
        }

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

        public T peekNext() {
            return current.getNext().getValue();
        }

        public T peekPrevious() {
            if (current.getPrevious() != null) {
                return current.getPrevious().getValue();
            } else return null;
        }
    }

    public LinkedList() {this.head = null;}

    public void add(T element) {
        Node<T> newNode = new Node<T>(element);
        count++;
        if (head == null) {
            this.head = newNode;
            this.tail = head;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
    }

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

    public void show() {
        Node node = head;

        while(node.getNext() != null) {
            System.out.print(node.getValue().toString() + ", ");
            node = node.getNext();
        }
        System.out.print(node.getValue().toString());
    }

    public LinkedListIterator iterator () {
        return new LinkedListIterator(head);
    }


    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
}
