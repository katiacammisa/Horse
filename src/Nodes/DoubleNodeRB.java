package Nodes;

public class DoubleNodeRB<T extends Comparable> {

    public T data;
    public boolean black;
    public DoubleNodeRB<T> left;
    public DoubleNodeRB<T> right;

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

    public void turnRed(){
        black = false;
    }

    public boolean isBlack(){
        return black;
    }
}
