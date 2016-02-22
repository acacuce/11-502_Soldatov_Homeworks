package ru.itis.inform;

import java.util.IllegalFormatException;

/**
 * Created by acacuce on 10.02.16.
 */
public class FareySequenceGeneratorArrayImpl implements IFareySequenceGenerator {
    private RationalNum arrayOfRationalNumbers [];
    private int lenghtOfSeries;
    private int currentLenghtOfSeries;
    private final int MAX_ARRAY_SIZE = 100;
    private final int MAX_SIZE_OF_SERIES = 10;
    
    public FareySequenceGeneratorArrayImpl(int sizeOfArrayRatioanalNumbers) {
        initFareySequenceGeneratorArrayImpl(sizeOfArrayRatioanalNumbers);
    }

    public FareySequenceGeneratorArrayImpl() {
        initFareySequenceGeneratorArrayImpl(MAX_ARRAY_SIZE);

    }
    private void initFareySequenceGeneratorArrayImpl (int sizeOfArrayOfRationalNumbers){
        this.arrayOfRationalNumbers = new RationalNum [sizeOfArrayOfRationalNumbers];
        this.arrayOfRationalNumbers [0] = new RationalNum(0, 1);
        this.arrayOfRationalNumbers [1] = new RationalNum(1, 1);
        currentLenghtOfSeries = 2;

    }

    private boolean isCorrect (int i, int iteration){
        boolean check = false;
        if (arrayOfRationalNumbers[i + 1] != null) {
            int checkedSum = arrayOfRationalNumbers[i].getDenominator() + arrayOfRationalNumbers[i + 1].getDenominator();
            if (checkedSum == iteration) check = true;
        }
        return check;
    }

    private RationalNum generateNewNumberInSeries (int i){
        int newA = arrayOfRationalNumbers[i].getNumerator() + arrayOfRationalNumbers[i + 1].getNumerator();
        int newB = arrayOfRationalNumbers[i].getDenominator() + arrayOfRationalNumbers[i + 1].getDenominator();
        return new RationalNum(newA, newB);
    }

    private void moveElements (int startPoint) {
        for (int i = currentLenghtOfSeries; i >= startPoint; i--) {
            arrayOfRationalNumbers[i + 1] = arrayOfRationalNumbers[i];
        }
    }

    private void generateSeries () {
        for (int iteration = 2; iteration <= lenghtOfSeries; iteration ++) {
            for (int i = 0; i < currentLenghtOfSeries; i ++) {
                if (isCorrect(i, iteration)) {
                    moveElements(i + 1);
                    arrayOfRationalNumbers [i + 1] = generateNewNumberInSeries(i);
                    currentLenghtOfSeries++;
                }
            }
        }
    }

    public void showSeries() {
        for(int i = 0; i < currentLenghtOfSeries; i++) {
            System.out.print(arrayOfRationalNumbers[i].getNumerator() + "  ");
        }
        System.out.println();
        for(int i = 0; i < currentLenghtOfSeries; i++) {
            System.out.print("-, ");
        }
        System.out.println();
        for(int i = 0; i < currentLenghtOfSeries; i++) {
            System.out.print(arrayOfRationalNumbers[i].getDenominator() + "  ");
        }
    }


    public RationalNum[] runFarey(int n) {
        if (n > 2 && n < MAX_ARRAY_SIZE) {
            this.lenghtOfSeries = n;
            generateSeries();
            return arrayOfRationalNumbers;
        }else {
            throw new IllegalArgumentException();
        }
    }
}
