package ru.itis.inform.linkedList;
public interface Iterator<T> {

    /**
     * Проверить, есть ли слеующий элемент
     * @return true - если есть, false - в противном случае
     */
    boolean hasNext();

    boolean hasPrevious();

    /**
     * Возвращает следующий элемент
     * @return возвращаемый элемент
     */
    T next();

    /**
     * Возвращает предыдущий элемент
     * @return возвращаемый элемент
     */
    T previous();

    /**
     * Вставляет новый элемент между next и previous
     * @param element
     */
    void insert(T element);

    /**
     *
     * @return value of next element without shift
     */
    T peekNext();

    /**
     *
     * @return value of previous element without shift
     */
    T peekPrevious();
}
