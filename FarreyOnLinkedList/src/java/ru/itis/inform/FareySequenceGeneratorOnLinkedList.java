package ru.itis.inform;

import ru.itis.inform.RationalNum;
import ru.itis.inform.linkedList.LinkedList;
import ru.itis.inform.linkedList.Node;

/**
 * Created by acacuce on 16.02.16.
 */
public class FareySequenceGeneratorOnLinkedList {
    private LinkedList listForSeries;
    private int sizeOfSeries;
    private int currentSize;

    public FareySequenceGeneratorOnLinkedList(int sizeOfSeries) {
        this.listForSeries = new LinkedList();
        listForSeries.add(new RationalNum(0, 1));
        listForSeries.add(new RationalNum(1, 1));

        this.sizeOfSeries = sizeOfSeries;
        this.currentSize  = 2;
    }

    public void generateSeries () {
        Node current = listForSeries.getFirst();
        Node next = current.getNext();
        while (currentSize <= sizeOfSeries) {
            while ( current.getNext() !=  null) {
                if (checkCondition(current, next)) {
                    RationalNum newRationalNumber = generateNewNumber(current, current.getNext());
                    listForSeries.insertElement(current, next, newRationalNumber );
                }
                current = next;
                next    = next.getNext();
            }
            currentSize ++;
            current = listForSeries.getFirst();
            next    = current.getNext();
        }
    }

    private RationalNum generateNewNumber (Node current, Node next){
        int currentNumerator   = current.getValue().getNumerator();
        int currentDenominator = current.getValue().getDenominator();
        int nextNumerator      = next.getValue().getNumerator();
        int nextDenominator    = next.getValue().getDenominator();
        int newNumerator       = currentNumerator + nextNumerator;
        int newDenominator     = currentDenominator + nextDenominator;
        return new RationalNum(newNumerator, newDenominator);
    }

    private boolean checkCondition (Node current, Node next) {
        int firstDenominator = current.getValue().getDenominator();
        int nextDenominator  = next.getValue().getDenominator();
        if (firstDenominator + nextDenominator == currentSize) {
            return true;
        } else {
            return false;
        }
    }
    public void showSeries () {
        Node node = listForSeries.getFirst();

        while (node.getNext() != null) {
            System.out.print(node.getValue().getNumerator() + "  ");
            node = node.getNext();
        }

        System.out.print(node.getValue().getNumerator() + " ");
        node = listForSeries.getFirst();
        System.out.println();

        while (node.getNext() != null) {
            System.out.print("-, ");
            node = node.getNext();
        }

        System.out.print("-, ");
        node = listForSeries.getFirst();
        System.out.println();

        while (node.getNext() != null) {
            System.out.print(node.getValue().getDenominator() + "  ");
            node = node.getNext();
        }
        System.out.print(node.getValue().getDenominator() + "  ");
    }
}
