
public interface BinarySearchTree {
    // добавляет элемент в дерево
    void insert(int element);

    // показывает дерево
    void show();

    void levelOrder ();

    public boolean find (int value);
    // выводит элементы дерева в прямом порядке
    void inOrderPrint();
}