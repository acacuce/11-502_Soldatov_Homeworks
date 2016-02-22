package ru.itis.inform;

import ru.itis.inform.linkedList.Iterator;
import ru.itis.inform.linkedList.LinkedList;
import ru.itis.inform.linkedList.List;
import ru.itis.inform.linkedList.Node;

import java.net.SocketPermission;

/**
 * Created by acacuce on 16.02.16.
 */
public class FareySequenceGeneratorOnLinkedList implements IFareySequenceGenerator {
    private List<RationalNum> listForSeries;
    private Iterator<RationalNum> iterator;
    private int sizeOfSeries;
    private int currentSize;

    public FareySequenceGeneratorOnLinkedList() {
        this.listForSeries = new LinkedList<RationalNum>();
        listForSeries.add(new RationalNum(0, 1));
        listForSeries.add(new RationalNum(1, 1));
        this.sizeOfSeries = 2;
        this.currentSize  = 2;
    }


    public void generateSeries () {
        while (currentSize <= sizeOfSeries) {
        this.iterator = listForSeries.iterator();
            while (iterator.hasNext()) {
                if (checkCondition()) {
                    RationalNum newRationalNumber = generateNewNumber();
                    iterator.insert(newRationalNumber);
                    iterator.next();
                }else iterator.next();
            }
            currentSize ++;
        }
    }

    private RationalNum generateNewNumber (){
        RationalNum previousNumber = iterator.previous();
        RationalNum nextNumber = iterator.next();
        int newNumerator       = previousNumber.getNumerator() + nextNumber.getNumerator();
        int newDenominator     = previousNumber.getDenominator() + nextNumber.getDenominator();
        return new RationalNum(newNumerator, newDenominator);
    }

    private boolean checkCondition () {
        boolean condition = false;
        if (iterator.peekPrevious() != null) {
            int firstDenominator = iterator.previous().getDenominator();
            int nextDenominator = iterator.next().getDenominator();
            if (firstDenominator + nextDenominator == currentSize) {
                condition = true;
            }
        }
        return condition;
    }
    
    public void showSeries () {
        Node<RationalNum> node = listForSeries.getHead();

        while (node.getNext() != null) {
            System.out.print(node.getValue().getNumerator() + "  ");
            node = node.getNext();
        }

        System.out.print(node.getValue().getNumerator() + " ");
        node = listForSeries.getHead();
        System.out.println();

        while (node.getNext() != null) {
            System.out.print("-, ");
            node = node.getNext();
        }

        System.out.print("-, ");
        node = listForSeries.getHead();
        System.out.println();

        while (node.getNext() != null) {
            System.out.print(node.getValue().getDenominator() + "  ");
            node = node.getNext();
        }
        System.out.print(node.getValue().getDenominator() + "  ");
    }

    public List<RationalNum> runFarey(int n) {
        if (n > 2) {
            this.sizeOfSeries = n;
            generateSeries();
            return listForSeries;
        }else throw new IllegalArgumentException();
    }
}
