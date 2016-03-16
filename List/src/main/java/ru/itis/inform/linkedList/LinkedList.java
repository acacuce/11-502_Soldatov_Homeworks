package ru.itis.inform.linkedList;

import ru.itis.inform.arrayList.ArrayList;

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
            } else return null;
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
            return current.getValue();
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
            this.head.setPrevious(null);
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

    public void append(LinkedList<T> list) {
        if (this.head != null){
            this.tail.setNext(list.getHead());
            this.tail = list.getTail();
            this.count += list.getCount();
        }else {
            this.head = list.getHead();
            this.tail = list.getTail();
            this.count = list.getCount();
        }
    }

    public static <T extends Comparable<T>> LinkedList<T> merge (LinkedList<T> first, LinkedList<T> second){
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();
        LinkedList<T> newList = new LinkedList();
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            T o1 = firstIterator.peekNext();
            T o2 = secondIterator.peekNext();
            int compare = o1.compareTo(o2);
            if (compare < 0) {
                newList.add(o1);
               o1 = firstIterator.next();
            }else
                if (compare > 0){
                    newList.add(o2);
                    o2 = secondIterator.next();
                }else {
                    newList.add(o1);
                    newList.add(o2);
                    o1 = firstIterator.next();
                    o2 = secondIterator.next();
                }
        }
        if (firstIterator != null) {
            while (firstIterator.hasNext()) {
                newList.add(firstIterator.next());
            }
        }
        if (secondIterator != null){
            while (secondIterator.hasNext()) {
                newList.add(secondIterator.next());
            }
        }
        return newList;
    }

    public static <T extends Comparable<T>> LinkedList<T> mergeSort(LinkedList<T> list) {
        ArrayList<LinkedList<T>> stack = new ArrayList<LinkedList<T>>(20);
        Iterator<T> iterator = list.iterator();
        int stackPosition = 0;
        while (iterator.hasNext()) {
            LinkedList<T> tempList = new LinkedList<T>();
            tempList.add(iterator.peekNext());
            stack.set(tempList, stackPosition);
            iterator.next();
            stackPosition++;
            while (stackPosition > 1 && (stack.get(stackPosition - 1).count) == (stack.get(stackPosition - 2).count)) {
                LinkedList<T> firstList = stack.get(stackPosition - 1);
                LinkedList<T> secondList = stack.get(stackPosition - 2);
                stack.set(merge(firstList, secondList),stackPosition - 2);
                stackPosition--;
            }
        }

        while (stackPosition > 1) {
            LinkedList<T> firstList = stack.get(stackPosition - 1);
            LinkedList<T> secondList = stack.get(stackPosition - 2);
            stack.set(merge(firstList, secondList),stackPosition - 2);
            stackPosition--;
        }
        return  stack.get(0);
    }




//    @Override
//    public boolean equals (Object another) {
//        System.out.print("equals?");
//        if (another == null) return false;
//        if (another == this) return true;
//        if (!(another instanceof LinkedList)) return false;
//
//        LinkedList anotherList = (LinkedList) another;
//
//        if (this.count != anotherList.getCount()) return false;
//
//        Node thisNode = head;
//        Node anotherNode = (Node) anotherList.getHead();
//
//        while(anotherNode != null) {
//            if (!(thisNode.equals(anotherNode))) return false;
//            thisNode = thisNode.getNext();
//            anotherNode = anotherNode.getNext();
//        }
//        return true;
//    }

//    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof List))
            return false;

        Iterator<T> e1 = iterator();
        Iterator<?> e2 = ((List<?>) o).iterator();
        while (e1.hasNext() && e2.hasNext()) {
            T o1 = e1.next();
            Object o2 = e2.next();
            if (!(o1==null ? o2==null : o1.equals(o2)))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
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

    public int getCount() {
        return count;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
}
