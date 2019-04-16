package BinaryTree;

import Nodes.DoubleNode;

import java.io.Serializable;

public class BinaryTree<T extends Serializable & Comparable> implements Serializable {

    private DoubleNode<T> root;


    public BinaryTree(){
    }

    public BinaryTree(T element){
        root = new DoubleNode<T>(element);
    }

    public BinaryTree(T element, BinaryTree<T> leftT, BinaryTree<T> rightT) {
        root = new DoubleNode<>(element, leftT.root, rightT.root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public BinaryTree<T> getLeft() {
        BinaryTree<T> t = new BinaryTree<T>();
        t.root = root.getLeft();
        return t;
    }

    public BinaryTree<T> getRight() {
        BinaryTree<T> t = new BinaryTree<T>();
        t.root = root.getRight();
        return t;
    }

    public T getRoot() {
        return root.getData();
    }
}
