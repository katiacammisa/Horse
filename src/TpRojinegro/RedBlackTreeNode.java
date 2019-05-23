package TpRojinegro;

import java.io.Serializable;

class RedBlackTreeNode<T extends Comparable<T> & Serializable> implements Serializable {

    public enum RBT_COLORS {
        RED, BLACK
    }

    private RedBlackTreeNode<T> parent;
    private RedBlackTreeNode<T> leftChild;
    private RedBlackTreeNode<T> rightChild;
    private RedBlackTreeNode.RBT_COLORS color;
    private T element;

    RedBlackTreeNode(){
        this.color = RedBlackTreeNode.RBT_COLORS.BLACK;
    }

    RedBlackTreeNode(T element) {
        this.element = element;
        this.color = RedBlackTreeNode.RBT_COLORS.BLACK;
    }

    RedBlackTreeNode<T> getParent() {
        return parent;
    }

    void setParent(RedBlackTreeNode<T> parent) {
        this.parent = parent;
    }

    RedBlackTreeNode<T> getLeftChild() {
        return leftChild;
    }

    void setLeftChild(RedBlackTreeNode<T> childLeft) {
        this.leftChild = childLeft;
    }

    RedBlackTreeNode<T> getRightChild() {
        return rightChild;
    }

    void setRightChild(RedBlackTreeNode<T> childRight) {
        this.rightChild = childRight;
    }

    RedBlackTreeNode.RBT_COLORS getColor() {
        return color;
    }

    void setColor(RedBlackTreeNode.RBT_COLORS color) {
        this.color = color;
    }

    T getElement() {
        return element;
    }
}
