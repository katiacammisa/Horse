package Nodes;

public class DoubleNodeRB<T extends Comparable> {
    T data;
    boolean black;
    DoubleNodeRB<T> left;
    DoubleNodeRB<T> right;

    public DoubleNodeRB(T data) {
        this.data = data;
    }
    public DoubleNodeRB(T data, DoubleNodeRB<T> left, DoubleNodeRB<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public DoubleNodeRB() {}

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleNodeRB<T> getLeft() {
        return left;
    }

    public void setLeft(DoubleNodeRB<T> left) {
        this.left = left;
    }

    public DoubleNodeRB<T> getRight() {
        return right;
    }

    public void setRight(DoubleNodeRB<T> right) {
        this.right = right;
    }

    public void turnBlack(){
        black = true;
    }

    public boolean isBlack(){
        return black;
    }
}
