package Nodes;

import java.io.Serializable;

public class DoubleNode<T extends Serializable> implements Serializable {
    T data;
    DoubleNode<T> left;
    DoubleNode<T> right;

    public DoubleNode(T data) {
        this.data = data;
    }

    public DoubleNode(T data, DoubleNode<T> left, DoubleNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public DoubleNode() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleNode<T> getLeft() {
        return left;
    }

    public void setLeft(DoubleNode<T> left) {
        this.left = left;
    }

    public DoubleNode<T> getRight() {
        return right;
    }

    public void setRight(DoubleNode<T> right) {
        this.right = right;
    }
}

