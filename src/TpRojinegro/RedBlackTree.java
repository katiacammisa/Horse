package TpRojinegro;

import Nodes.DoubleNode;
import Nodes.DoubleNodeSearch;
import TpBinaryTreeSearch.SearchBinaryTree;

import java.io.Serializable;

public class RedBlackTree<T extends Comparable>{

    private DoubleNodeSearch<T> root;

    public RedBlackTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void setRoot(DoubleNodeSearch<T> root) {
        this.root = root;
    }

    public RedBlackTree<T> getLeft() {
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        RedBlackTree<T> t = new RedBlackTree<>();
        t.root = root.getLeft();
        return t;
    }

    public RedBlackTree<T> getRight() {
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        RedBlackTree<T> t = new RedBlackTree<>();
        t.root = root.getRight();
        return t;
    }

    public Object getRoot() {
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        return root.getData();
    }

    public boolean exists(Comparable x){
        return exists(root, x);
    }

    public Object getMin(){
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        return getMin(root).getData();
    }

    private boolean exists(DoubleNodeSearch<T> t, Comparable x) {
        if (t == null)
            return false;

        if (x.compareTo(t.getData()) == 0)
            return true;
        else if (x.compareTo( t.getData())< 0)
            return exists(t.getLeft(), x);
        else
            return exists(t.getRight(), x);
    }

    private DoubleNodeSearch<T> getMin(DoubleNodeSearch<T> t){
        if (t.getLeft() == null)
            return t;
        else
            return getMin(t.getLeft());
    }

    public Object getMax(){
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        return getMax(root).getData();
    }

    private DoubleNodeSearch<T> getMax(DoubleNodeSearch<T> t){
        if (t.getRight() == null)
            return t;
        else
            return getMax(t.getRight());
    }

    public Object search(Comparable x){
        if(!exists(x)) {
            throw new RuntimeException("The element doesn't exist");
        }
        return search(root, x).getData();
    }

    private DoubleNodeSearch<T> search(DoubleNodeSearch<T> t, Comparable x){
        if (x.compareTo( t.getData())== 0)
            return t;
        else if (x.compareTo( t.getData())< 0)
            return search(t.getLeft(), x);
        else
            return search(t.getRight(), x);
    }




}
