package TpRojinegro;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class RedBlackTree<T extends Comparable & Serializable> implements Serializable {

    private RedBlackNode<T> header;
    private RedBlackNode<T> nullNode;
    private RedBlackNode<T> current;
    private RedBlackNode<T> parent;
    private RedBlackNode<T> grand;
    private RedBlackNode<T> great;
    private static final int BLACK = 1;
    private static final int RED = 0;

    public RedBlackTree() {

         nullNode = new RedBlackNode<>(null);
         nullNode.left = nullNode.right = nullNode;
         header = new RedBlackNode<>( null );
         header.left = header.right = nullNode;
    }


    private RedBlackNode<T> rotate( T item, RedBlackNode<T> parent) {
         if(compare( item, parent)<0)
             return parent.left = compare( item, parent.left )<0?
                 rotateWithLeftChild( parent.left ) :
         rotateWithRightChild( parent.left );
         else
         return parent.right = compare( item, parent.right )<0?
                rotateWithLeftChild( parent.right ) :
         rotateWithRightChild( parent.right );
    }

    private final int compare(T item, RedBlackNode<T> t) {
        if(t == header)
            return 1;
        else
            return item.compareTo(t.element);
    }

    private void handleReorient(T item) {
         current.color = RED;
         current.left.color = BLACK;
         current.right.color = BLACK;

         if( parent.color == RED )
             {
             grand.color = RED;
             if( ( compare( item, grand ) < 0 ) !=
                     ( compare( item, parent )<0))
             parent = rotate( item, grand );
             current = rotate( item, great );
             current.color = BLACK;
             }
         header.right.color = BLACK;

    }

    public void insert(T item) {
         current = parent = grand = header;
         nullNode.element = item;

         while(compare(item, current) != 0) {
             great = grand; grand = parent; parent = current;
             current = compare(item, current) < 0 ? current.left : current.right;
             if(current.left.color == RED && current.right.color == RED )
                handleReorient(item);
         }

         if(current != nullNode)
             return;
         current = new RedBlackNode<>(item, nullNode, nullNode);

         if(compare(item, parent) < 0)
             parent.left = current;
         else
             parent.right = current;
         handleReorient(item);
    }

    private RedBlackNode rotateWithLeftChild(RedBlackNode B) {
        RedBlackNode A = B.left;
        B.left = A.right;
        A.right = B;
        return A;
    }

    private RedBlackNode<T> rotateWithRightChild(RedBlackNode A) {
        RedBlackNode B = A.right;
        A.right = B.left;
        B.left = A;
        return B;
    }







    public void delete(T x) {

    }


    public int size(){
        return size(this);
    }

    private int size(RedBlackTree a) {
        if (a.isEmpty()) {
            return 0;
        } else {
            return 1 + size(a.getRight()) + size(a.getLeft());
        }
    }

    public void print(){
        inOrder(this);
    }

    public void inOrder(RedBlackTree<T> a) {
        if (!a.isEmpty()) {
            inOrder(a.getLeft());
            System.out.println(a.getRoot());
            inOrder(a.getRight());
        }
    }









    public boolean isEmpty() {
        return header == null;
    }

    public void setRoot(RedBlackNode<T> root) {
        this.header = root;
    }

    public RedBlackTree<T> getLeft() {
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        RedBlackTree<T> t = new RedBlackTree<>();
        t.header = header.left;
        return t;
    }

    public RedBlackTree<T> getRight() {
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        RedBlackTree<T> t = new RedBlackTree<>();
        t.header = header.right;
        return t;
    }

    public T getRoot() {
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        return header.element;
    }


    public RedBlackNode<T> getRootNode() {
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        return header;
    }

    public boolean exists(Comparable x){
        return exists(header, x);
    }

    public Object getMin(){
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        return getMin(header).element;
    }

    private boolean exists(RedBlackNode<T> t, Comparable x) {
        if (t == null)
            return false;

        if (x.compareTo(t.element) == 0)
            return true;
        else if (x.compareTo( t.element) < 0)
            return exists(t.left, x);
        else
            return exists(t.right, x);
    }

    private RedBlackNode<T> getMin(RedBlackNode<T> t){
        if (t.left == null)
            return t;
        else
            return getMin(t.left);
    }

    public Object getMax(){
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        return getMax(header).element;
    }

    private RedBlackNode<T> getMax(RedBlackNode<T> t){
        if (t.right == null)
            return t;
        else
            return getMax(t.right);
    }

    public T search(java.lang.Comparable x){
        if(!exists(x)) {
            throw new RuntimeException("The Book doesn't exist");
        }
        return search(header, x).element;
    }

    private RedBlackNode<T> search(RedBlackNode<T> t, java.lang.Comparable x){
        if (x.compareTo( t.element)== 0)
            return t;
        else if (x.compareTo( t.element)< 0)
            return search(t.left, x);
        else
            return search(t.right, x);
    }
}
