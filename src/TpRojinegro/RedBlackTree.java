package TpRojinegro;

import Nodes.DoubleNode;
import Nodes.DoubleNodeRB;
import TpBinaryTreeSearch.SearchBinaryTree;

import java.io.Serializable;

public class RedBlackTree<T extends Comparable>{

    private DoubleNodeRB<T> root;
    private DoubleNodeRB<T> current;
    private DoubleNodeRB<T> parent;
    private DoubleNodeRB<T> grand;
    private DoubleNodeRB<T> great;
    private static DoubleNodeRB nullNode;

    static
    {
        nullNode = new DoubleNodeRB(0);
        nullNode.right = nullNode;
        nullNode.left = nullNode;
    }

    public RedBlackTree() {
        root = nullNode;
    }

    public RedBlackTree(T data){
        root = new DoubleNodeRB<>(data);
        root.setLeft(nullNode);
        root.setRight(nullNode);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void setRoot(DoubleNodeRB<T> root) {
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

    private boolean exists(DoubleNodeRB<T> t, Comparable x) {
        if (t == null)
            return false;

        if (x.compareTo(t.getData()) == 0)
            return true;
        else if (x.compareTo( t.getData())< 0)
            return exists(t.getLeft(), x);
        else
            return exists(t.getRight(), x);
    }

    private DoubleNodeRB<T> getMin(DoubleNodeRB<T> t){
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

    private DoubleNodeRB<T> getMax(DoubleNodeRB<T> t){
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

    private DoubleNodeRB<T> search(DoubleNodeRB<T> t, Comparable x){
        if (x.compareTo( t.getData())== 0)
            return t;
        else if (x.compareTo( t.getData())< 0)
            return search(t.getLeft(), x);
        else
            return search(t.getRight(), x);
    }

    public void insert(T item){
        current = parent = grand = root;
        nullNode.data = item;
        while (current.data != item)
        {
            great = grand;
            grand = parent;
            parent = current;
            current = item.compareTo(current.data) > 0 ? current.left : current.right;

            if (!current.left.isBlack() && !current.right.isBlack())
                handleReorient( item );
        }

        if (current != nullNode)
            return;
        current = new DoubleNodeRB<>(item, nullNode, nullNode);

        if (item.compareTo(parent.data) > 0)
            parent.left = current;
        else
            parent.right = current;
        handleReorient( item );
    }

    private void handleReorient(T item) {
        // Do the color flip
        current.turnRed();
        current.left.turnBlack();
        current.right.turnBlack();

        if (!parent.isBlack())
        {
            grand.turnRed();
            if (item.compareTo(grand.data) < 0 != item.compareTo(parent.data) < 0)
                parent = rotate( item, grand );
            current = rotate(item, great );
            current.turnBlack();
        }
        root.right.turnBlack();
    }

    private DoubleNodeRB<T> rotate(T item, DoubleNodeRB<T> parent) {
        if(item.compareTo(parent.data) < 0)
            return parent.left = item.compareTo(parent.left.data) < 0 ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;
        else
            return parent.right = item.compareTo(parent.right.data) < 0 ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);
    }

    private DoubleNodeRB rotateWithLeftChild(DoubleNodeRB k2)
    {
        DoubleNodeRB k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    private DoubleNodeRB<T> rotateWithRightChild(DoubleNodeRB k1) {
        DoubleNodeRB k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    public int countNodes()
    {
        return countNodes(root.right);
    }
    private int countNodes(DoubleNodeRB r)
    {
        if (r == nullNode)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }

    public void delete(T data){}





}
