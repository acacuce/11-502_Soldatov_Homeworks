package ru.itis.inform.linkedList;


import ru.itis.inform.IRationalNum;

public interface List<T> {

    /**
     * Добавить элемент в начало списка
     * @param element значение добавляемого элемента
     */
    void add(T element);

    /**
     * Удаление элемента по значению
     * @param element значение элемента
     */
    void remove(T element);

    public Iterator<T> iterator ();

    public Node getHead ();

}
