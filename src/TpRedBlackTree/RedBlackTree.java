package TpRedBlackTree;

import java.io.*;
import java.util.ArrayList;

public class RedBlackTree<T extends Comparable<T> & Serializable> implements Serializable {

    private RedBlackTreeNode<T> nil;
    private RedBlackTreeNode<T> root;

    RedBlackTree() {
    }

    RedBlackTree(T key) {
        this(new RedBlackTreeNode<>(key));
    }

    private RedBlackTree(RedBlackTreeNode<T> root) {
        this.nil = new RedBlackTreeNode<>();
        this.root = root;
        root.setLeftChild(nil);
        root.setRightChild(nil);
        root.setParent(nil);
        root.setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
    }

    void setRootNode(RedBlackTreeNode<T> root) {
        this.root = root;
    }

    RedBlackTreeNode<T> getRootNode() {
        return root;
    }

    RedBlackTreeNode<T> getNilNode() {
        return nil;
    }

//    public RedBlackTreeNode<T> treeSuccessor(RedBlackTreeNode<T> node) {
//        if (!node.getRightChild().equals(nil)) {
//            return getMinNodeStartingFrom(node.getRightChild());
//        }
//
//        RedBlackTreeNode<T> successor = node.getParent();
//        while (!successor.equals(nil) && node.equals(successor.getRightChild())) {
//            node = successor;
//            successor = successor.getParent();
//        }
//        return successor;
//    }
//
//    public RedBlackTreeNode<T> treePredecessor(RedBlackTreeNode<T> node) {
//        if (!node.getLeftChild().equals(nil)) {
//            return getMaxNodeStartingFrom(node.getLeftChild());
//        }
//
//        RedBlackTreeNode<T> predecessor = node.getParent();
//        while (!predecessor.equals(nil) && node.equals(predecessor.getLeftChild())) {
//            node = predecessor;
//            predecessor = predecessor.getParent();
//        }
//        return predecessor;
//    }

    RedBlackTreeNode<T> search(T key) {
        RedBlackTreeNode<T> x = root;
        while (!x.equals(nil)) {
            if (x.getElement().equals(key)) {
                return x;
            } else if (x.getElement().compareTo(key) > 0) {
                x = x.getLeftChild();
            } else {
                x = x.getRightChild();
            }
        }
        return null;
    }

    private RedBlackTreeNode<T> getMinNodeStartingFrom(RedBlackTreeNode<T> startingNode) {
        RedBlackTreeNode<T> x = startingNode;
        RedBlackTreeNode<T> y = nil;
        while (!x.equals(nil)) {
            y = x;
            x = x.getLeftChild();
        }
        if (y != nil) {
            return y;
        } else {
            return null;
        }
    }

//    public RedBlackTreeNode<T> getMinNode() {
//        return getMinNodeStartingFrom(root);
//    }

//    private RedBlackTreeNode<T> getMaxNodeStartingFrom(RedBlackTreeNode<T> startingNode) {
//        RedBlackTreeNode<T> x = startingNode;
//        RedBlackTreeNode<T> y = nil;
//        while (!x.equals(nil)) {
//            y = x;
//            x = x.getRightChild();
//        }
//        if (y != nil) {
//            return y;
//        } else {
//            return null;
//        }
//    }

//    public RedBlackTreeNode<T> getMaxNode() {
//        return getMaxNodeStartingFrom(root);
//    }

    void insert(T element) {
        insert(new RedBlackTreeNode<>(element));
    }

    private void insert(RedBlackTreeNode<T> node) {
        RedBlackTreeNode<T> x = root;
        RedBlackTreeNode<T> y = nil;
        while (!x.equals(nil)) {
            y = x;
            if (node.getElement().compareTo(x.getElement()) >= 0) {
                x = x.getRightChild();
            } else if (node.getElement().compareTo(x.getElement()) < 0) {
                x = x.getLeftChild();
            }
        }
        if (y.getElement().compareTo(node.getElement()) > 0) {
            y.setLeftChild(node);
        } else {
            y.setRightChild(node);
        }
        node.setParent(y);
        node.setLeftChild(nil);
        node.setRightChild(nil);
        node.setColor(RedBlackTreeNode.RBT_COLORS.RED);
        RedBlackTreeUtils.rbtInsertFixup(this, node);
    }

    void delete(RedBlackTreeNode<T> node) {
        RedBlackTreeNode<T> y = node;
        RedBlackTreeNode<T> x;
        RedBlackTreeNode.RBT_COLORS y_original_color = y.getColor();
        if (node.getLeftChild().equals(nil)) {
            x = node.getRightChild();
            RedBlackTreeUtils.rbtTransplant(this, node, node.getRightChild());
        } else if (node.getRightChild().equals(nil)) {
            x = node.getLeftChild();
            RedBlackTreeUtils.rbtTransplant(this, node, node.getLeftChild());
        } else {
            y = getMinNodeStartingFrom(node.getRightChild());
            assert y != null;
            y_original_color = y.getColor();
            x = y.getRightChild();
            if (y.getParent().equals(node)) {
                x.setParent(y);
            } else {
                RedBlackTreeUtils.rbtTransplant(this, y, y.getRightChild());
                y.setRightChild(node.getRightChild());
                y.getRightChild().setParent(y);
            }
            RedBlackTreeUtils.rbtTransplant(this, node, y);
            y.setLeftChild(node.getLeftChild());
            y.getLeftChild().setParent(y);
            y.setColor(node.getColor());
        }
        if (y_original_color == RedBlackTreeNode.RBT_COLORS.BLACK) {
            RedBlackTreeUtils.deleteFixup(this, x);
        }
    }

    void printInOrderAllNodes() {
        if (root != nil) {
            printInOrderAllNodes(root, 0, "root");
        } else {
            System.out.println("The RBT is empty");
        }
    }

    private void printInOrderAllNodes(RedBlackTreeNode<T> node, int level, String typeChild) {
        if (node != nil) {
            if (node.getLeftChild() != nil) {
                printInOrderAllNodes(node.getLeftChild(), level + 1, "left child");
            }

            if (node.getElement() != null && node.getColor() != null) {
                String output = "Node at level " + level + ". Key: " + node.getElement().toString() + ". Color: "
                        + node.getColor().toString() + ". Type child: " + typeChild + ". Parent: "
                        + node.getParent().getElement();
                System.out.println(output);
            }

            if (node.getRightChild() != nil) {
                printInOrderAllNodes(node.getRightChild(), level + 1, "right child");
            }
        }
    }

    public void printPreOrderAllNodes() {
        if (root != nil) {
            printPreOrderAllNodes(root, 0, "root");
        } else {
            System.out.println("The RBT is empty");
        }
    }

    private void printPreOrderAllNodes(RedBlackTreeNode<T> node, int level, String typeChild) {
        if (node != nil) {

            if (node.getElement() != null && node.getColor() != null) {
                String output = "Node at level " + level + ". Key: " + node.getElement().toString() + ". Color: "
                        + node.getColor().toString() + ". Type child: " + typeChild + ". Parent: "
                        + node.getParent().getElement();
                System.out.println(output);
            }

            if (node.getLeftChild() != nil) {
                printPreOrderAllNodes(node.getLeftChild(), level + 1, "left child");
            }

            if (node.getRightChild() != nil) {
                printPreOrderAllNodes(node.getRightChild(), level + 1, "right child");
            }
        }
    }


    public void printPostOrderAllNodes() {
        if (root != nil) {
            printPostOrderAllNodes(root, 0, "root");
        } else {
            System.out.println("The RBT is empty");
        }
    }

    private void printPostOrderAllNodes(RedBlackTreeNode<T> node, int level, String typeChild) {
        if (node != nil) {

            if (node.getLeftChild() != nil) {
                printPostOrderAllNodes(node.getLeftChild(), level + 1, "left child");
            }

            if (node.getRightChild() != nil) {
                printPostOrderAllNodes(node.getRightChild(), level + 1, "right child");
            }

            if (node.getElement() != null && node.getColor() != null) {
                String output = "Node at level " + level + ". Key: " + node.getElement().toString() + ". Color: "
                        + node.getColor().toString() + ". Type child: " + typeChild + ". Parent: "
                        + node.getParent().getElement();
                System.out.println(output);
            }
        }
    }

    public ArrayList<T> toPreOrderList() {
        ArrayList<T> list = new ArrayList<>();
        fromRBTtoPreOrderList(root, list);
        return list;
    }

    private void fromRBTtoPreOrderList(RedBlackTreeNode<T> node, ArrayList<T> list) {

        list.add(node.getElement());

        if (node.getLeftChild() != nil) {
            fromRBTtoPreOrderList(node.getLeftChild(), list);
        }

        if (node.getRightChild() != nil) {
            fromRBTtoPreOrderList(node.getRightChild(), list);
        }
    }

    ArrayList<T> toInOrderList() {
        ArrayList<T> list = new ArrayList<>();
        fromRBTtoInOrderList(root, list);
        return list;
    }

    private void fromRBTtoInOrderList(RedBlackTreeNode<T> node, ArrayList<T> list) {

        if (node.getLeftChild() != nil) {
            fromRBTtoInOrderList(node.getLeftChild(), list);
        }

        list.add(node.getElement());

        if (node.getRightChild() != nil) {
            fromRBTtoInOrderList(node.getRightChild(), list);
        }
    }

    public ArrayList<T> toPostOrderList() {
        ArrayList<T> list = new ArrayList<>();
        fromRBTtoPostOrderList(root, list);
        return list;
    }

    private void fromRBTtoPostOrderList(RedBlackTreeNode<T> node, ArrayList<T> list) {

        if (node.getLeftChild() != nil) {
            fromRBTtoPostOrderList(node.getLeftChild(), list);
        }

        if (node.getRightChild() != nil) {
            fromRBTtoPostOrderList(node.getRightChild(), list);
        }

        list.add(node.getElement());
    }


    public boolean exists(Comparable x){
        return exists(root, x);
    }

    private boolean exists(RedBlackTreeNode<T> t, Comparable x) {
        if (t == null)
            return false;

        if (x.compareTo(t.getElement()) == 0)
            return true;
        else if (x.compareTo(t.getElement()) < 0)
            return exists(t.getLeftChild(), x);
        else
            return exists(t.getRightChild(), x);
    }

    void save() {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Hola"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert oos != null;
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    RedBlackTree recover() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Hola"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        RedBlackTree a = null;
        try {
            assert ois != null;
            a = (RedBlackTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }

    public int size(RedBlackTree a) {
        if (a.isEmpty()) {
            return 0;
        } else {
            return 1 + size(a.getRight()) + size(a.getLeft());
        }
    }

    public boolean isEmpty() {
        return root == null || root.getElement() == null;
    }

    private RedBlackTree<T> getLeft() {
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        RedBlackTree<T> t = new RedBlackTree<>();
        t.setRootNode(getRootNode().getLeftChild());
        return t;
    }

    private RedBlackTree<T> getRight() {
        if(isEmpty()) {
            throw new RuntimeException("The tree is empty");
        }
        return new RedBlackTree<>(getRootNode().getRightChild());
    }
}