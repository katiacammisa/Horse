package TpRojinegro;

import java.io.Serializable;

public class RedBlackNode<T extends Comparable & Serializable> implements Serializable {

        T element;
        RedBlackNode<T> left;
        RedBlackNode<T> right;
        int color;

        // Constructors
        RedBlackNode(T theElement) {
            this(theElement, null, null);
        }

        RedBlackNode(T theElement, RedBlackNode<T> lt, RedBlackNode<T> rt) {
            element = theElement;
            left = lt;
            right = rt;
            color = 1;
        }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public RedBlackNode<T> getLeft() {
        return left;
    }

    public void setLeft(RedBlackNode<T> left) {
        this.left = left;
    }

    public RedBlackNode<T> getRight() {
        return right;
    }

    public void setRight(RedBlackNode<T> right) {
        this.right = right;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
