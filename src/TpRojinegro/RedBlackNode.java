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

}
