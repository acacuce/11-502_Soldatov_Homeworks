package ru.itis.inform.linkedList;


import ru.itis.inform.IRationalNum;

public interface List {

    /**
     * Добавить элемент в начало списка
     * @param element значение добавляемого элемента
     */
    void add(IRationalNum element);

    /**
     * Удаление элемента по значению
     * @param element значение элемента
     */
    void remove(IRationalNum element);
    void insertElement (Node first, Node second, IRationalNum element);
}
