import com.sun.source.tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeImpl implements BinarySearchTree {

    private  Node root;
    private Queue<Node> queue;
    private Node insertNode(Node root, int element)
    {
        if (root == null) {
            root = new Node(element);
            /*
            root.setLeft(null);
            root.setRight(null);
            */
        } else if (element <= root.getData()) {
            root.setLeft(insertNode(root.getLeft(), element));
        } else {
            root.setRight(insertNode(root.getRight(), element));
        }

        return root;
    }

    private void showRec(Node root, int level) {
        if (root != null) {
            showRec(root.getRight(), level + 1);

            for (int i = 0; i < level; i++) {
                System.out.print("   ");
            }

            System.out.println(root.getData());

            showRec(root.getLeft(), level + 1);
        }
    }

    public boolean find (int value) {
       return findNode(root, value);
    }

    private boolean findNode (Node root,int value) {
        boolean isFind = false;
        if (root == null)
            return isFind;

        if (value == root.getData()) {
            isFind = true;
            return isFind;
        }

        if (value > root.getData()) {
            isFind = findNode(root.getRight(), value);
        }

        if (value < root.getData()) {
            isFind = findNode(root.getLeft(), value);
        }


        return isFind;
    }

    public void insert(int element) {
        this.root = insertNode(this.root, element);
    }

    public void show() {
        showRec(root, 0);
    }

    private void inOrder(Node root)
    {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrder(root.getRight());
        }
    }

    public void levelOrder () {
        Queue<Node> treeQueue = new LinkedList<Node>();
        if (root != null) {
            treeQueue.add(root);
            while (!treeQueue.isEmpty()) {
//                System.out.print(treeQueue.peek().getData() + ", ");
                Node temp = treeQueue.poll();
                if (temp.getLeft() != null) {
                    treeQueue.add(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    treeQueue.add(temp.getRight());
                }
            }

        }
    }


    public void inOrderPrint() {
        inOrder(this.root);
    }
}
