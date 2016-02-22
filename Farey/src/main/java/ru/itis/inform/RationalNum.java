package ru.itis.inform;

/**
 * Created by acacuce on 10.02.16.
 */
public class RationalNum implements IRationalNum {
    private int firstNumber;
    private int secondNumber;
    public RationalNum(int a, int b) {
        if (b != 0) {
            this.firstNumber = a;
            this.secondNumber = b;
        } else throw new IllegalArgumentException();
    }

    @Override
    public int getNumerator() {
        return this.firstNumber;
    }

    @Override
    public int getDenominator() {
        return this.secondNumber;
    }
}
