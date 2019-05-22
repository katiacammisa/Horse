package TpBinaryTreeSearch;

import BinaryTree.BinaryTree;
import Nodes.DoubleNodeSearch;

import java.io.Serializable;

public class SearchBinaryTree<T extends Comparable> {

    private DoubleNodeSearch<T> root;

    public SearchBinaryTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void setRoot(DoubleNodeSearch<T> root) {
        this.root = root;
    }

    public SearchBinaryTree<T> getLeft() {
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        SearchBinaryTree<T> t = new SearchBinaryTree<T>();
        t.root = root.getLeft();
        return t;
    }

    public SearchBinaryTree<T> getRight() {
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        SearchBinaryTree<T> t = new SearchBinaryTree<T>();
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

    public Object getMax(){
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        return getMax(root).getData();
    }

    public Object search(Comparable x){
        if(!exists(x)) {
            throw new RuntimeException("The Book doesn't exist");
        }
        return search(root, x).getData();
    }

    public void insert(Comparable x){
        if(exists(x)) {
            throw new RuntimeException("The Book doesn't exist");
        }
        root = insert(root, x);
    }

    public void eliminate(Comparable x){
        if(!exists(x)) {
            throw new RuntimeException("The Book doesn't exist");
        }
        root = eliminate(root, x);
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

    private DoubleNodeSearch<T> getMax(DoubleNodeSearch<T> t){
        if (t.getRight() == null)
            return t;
        else
            return getMax(t.getRight());
    }

    private DoubleNodeSearch<T> search(DoubleNodeSearch<T> t, Comparable x){
        if (x.compareTo( t.getData())== 0)
            return t;
        else if (x.compareTo( t.getData())< 0)
            return search(t.getLeft(), x);
        else
            return search(t.getRight(), x);
    }

    private DoubleNodeSearch<T> insert (DoubleNodeSearch<T> t, Comparable x) {
        if (t == null){
            t = new DoubleNodeSearch<T>();
            t.setData((T)x);
        }
        else if (x.compareTo(t.getData()) < 0)
            t.setLeft(insert(t.getLeft(), x));
        else if(x.compareTo(t.getData()) > 0) {
            t.setRight(insert(t.getRight(), x));
        } else
        {
            throw new RuntimeException("Can't have repeated elements");
        }
        return t;
    }

    private DoubleNodeSearch<T> eliminate (DoubleNodeSearch<T> t, Comparable x) {
        if(t == null) {
            throw new RuntimeException("The node is empty");
        }
        if (x.compareTo(t.getData()) < 0)
            t.setLeft(eliminate(t.getLeft(), x));
        else if (x.compareTo(t.getData()) > 0)
            t.setRight(eliminate(t.getRight(), x));
        else
        if (t.getLeft() != null && t.getRight() != null ) {
            t.setData(getMin(t.getRight()).getData());
            t.setRight(eliminateMin(t.getRight()));
        }
        else if (t.getLeft() != null)
            t = t.getLeft();
        else
            t = t.getRight();
        return t;
    }

    private DoubleNodeSearch<T> eliminateMin(DoubleNodeSearch<T> t){
        if (t.getLeft() != null)
            t.setLeft(eliminateMin(t.getLeft()));
        else
            t = t.getRight();
        return t;
    }












}
