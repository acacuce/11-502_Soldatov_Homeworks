package ru.itis.inform.arrayList;

/**
 * Created by acacuce on 28.02.16.
 */
public class ArrayList<T> {
    private Object [] elements;
    private final int MAX_SIZE = 100;
    private int count;
    private int sizeOfArray;

    public ArrayList(int size) {
        initArrayList(size);
    }

    public ArrayList(){
        initArrayList(MAX_SIZE);
    }

    private void initArrayList (int size) {
        this.elements = new Object[size];
        this.sizeOfArray = size;
    }

    public void set(T element, int index) {
        if (index >= 0 && index < sizeOfArray){
            elements[index] = element;
        }else throw new IllegalArgumentException();
    }
    @SuppressWarnings("unchecked")
    public T get (int index){
        if (index >= 0 && index < sizeOfArray) {
            return (T)this.elements[index];
        } else throw new IllegalArgumentException();
    }

//    public void recreate

    public int getSizeOfArray() {
        return sizeOfArray;
    }
}
