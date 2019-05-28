package TpRedBlackTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class RedBlackTree<T extends Comparable<T> & Serializable> implements Serializable {

    private RedBlackTreeNode<T> nil;
    private RedBlackTreeNode<T> root;

    RedBlackTree() {
    }

    RedBlackTree(T element) {
        this(new RedBlackTreeNode<>(element));
    }

    private RedBlackTree(RedBlackTreeNode<T> root) {
        this.nil = new RedBlackTreeNode<>();
        this.root = new RedBlackTreeNode<>();
        this.root = root;
        root.setLeftChild(nil);
        root.setRightChild(nil);
        root.setParent(nil);
        root.setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
    }

    void setRootNode(RedBlackTreeNode<T> root2) {
        root = root2;
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

    @SuppressWarnings("SuspiciousNameCombination")
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

    public RedBlackTreeNode<T> getMinNode() {
        return getMinNodeStartingFrom(root);
    }

    private RedBlackTreeNode<T> getMaxNodeStartingFrom(RedBlackTreeNode<T> startingNode) {
        RedBlackTreeNode<T> x = startingNode;
        RedBlackTreeNode<T> y = nil;
        while (!x.equals(nil)) {
            y = x;
            x = x.getRightChild();
        }
        if (y != nil) {
            return y;
        } else {
            return null;
        }
    }

    public RedBlackTreeNode<T> getMaxNode() {
        return getMaxNodeStartingFrom(root);
    }

    void insert(T key) {
        insert(new RedBlackTreeNode<>(key));
    }

    private void insert(RedBlackTreeNode<T> node) {
        RedBlackTreeNode<T> x = root;
        RedBlackTreeNode<T> y = nil;

        while (!Objects.equals(x, nil)) {
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
//
//    public void insert2(T key) {
//        insert2(new RedBlackTreeNode<T>(key));
//    }
//
//    // @param: z, the node to be inserted into the Tree rooted at root
//    // Inserts z into the appropriate position in the RedBlackTree while
//    // updating numLeft and numRight values.
//    private void insert2(RedBlackTreeNode<T> node) {
//
//        // Create a reference to root & initialize a node to nil
//        RedBlackTreeNode<T> y = nil;
//        RedBlackTreeNode<T> x = root;
//
//        // While we haven't reached a the end of the tree keep
//        // tryint to figure out where z should go
//        while (x != null) {
//            y = x;
//            // if z.key is < than the current key, go left
//            if (node.getElement().compareTo(x.getElement()) < 0){
//
//                // Update x.numLeft as z is < than x
//                x.numLeft++;
//                x = x.left;
//            }
//
//            // else z.key >= x.key so go right.
//            else{
//
//                // Update x.numGreater as z is => x
//                x.numRight++;
//                x = x.right;
//            }
//        }
//        // y will hold z's parent
//        z.parent = y;
//
//        // Depending on the value of y.key, put z as the left or
//        // right child of y
//        if (isNil(y))
//            root = z;
//        else if (z.key.compareTo(y.key) < 0)
//            y.left = z;
//        else
//            y.right = z;
//
//        // Initialize z's children to nil and z's color to red
//        z.left = nil;
//        z.right = nil;
//        z.color = RedBlackNode.RED;
//
//        // Call insertFixup(z)
//        insertFixup(z);
//
//    }// end insert(RedBlackNode z)
//
//
//    // @param: z, the node which was inserted and may have caused a violation
//    // of the RedBlackTree properties
//    // Fixes up the violation of the RedBlackTree properties that may have
//    // been caused during insert(z)
//    private void insertFixup(RedBlackTreeNode<T> node) {
//
//        RedBlackTreeNode<T> y = nil;
//        // While there is a violation of the RedBlackTree properties..
//        while (node.getParent().getColor() == RedBlackTreeNode.RBT_COLORS.RED) {
//
//            // If z's parent is the the left child of it's parent.
//            if (node.getParent() == node.getParent().getParent().getLeftChild()) {
//
//                // Initialize y to z 's cousin
//                y = node.getParent().getParent().getRightChild();
//
//                // Case 1: if y is red...recolor
//                if (y.getColor() == RedBlackTreeNode.RBT_COLORS.RED) {
//                    node.getParent().setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
//                    y.setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
//                    node.getParent().getParent().setColor(RedBlackTreeNode.RBT_COLORS.RED);
//                    node = node.getParent().getParent();
//                }
//                // Case 2: if y is black & z is a right child
//                else if (node == node.getParent().getRightChild()) {
//
//                    // leftRotaet around z's parent
//                    node = node.getParent();
//                    leftRotate(node);
//                }
//
//                // Case 3: else y is black & z is a left child
//                else {
//                    // recolor and rotate round z's grandpa
//                    z.parent.color = RedBlackNode.BLACK;
//                    z.parent.parent.color = RedBlackNode.RED;
//                    rightRotate(z.parent.parent);
//                }
//            }
//
//            // If z's parent is the right child of it's parent.
//            else {
//
//                // Initialize y to z's cousin
//                y = z.parent.parent.left;
//
//                // Case 1: if y is red...recolor
//                if (y.color == RedBlackNode.RED) {
//                    z.parent.color = RedBlackNode.BLACK;
//                    y.color = RedBlackNode.BLACK;
//                    z.parent.parent.color = RedBlackNode.RED;
//                    z = z.parent.parent;
//                }
//
//                // Case 2: if y is black and z is a left child
//                else if (z == z.parent.left) {
//                    // rightRotate around z's parent
//                    z = z.parent;
//                    rightRotate(z);
//                }
//                // Case 3: if y  is black and z is a right child
//                else {
//                    // recolor and rotate around z's grandpa
//                    z.parent.color = RedBlackNode.BLACK;
//                    z.parent.parent.color = RedBlackNode.RED;
//                    leftRotate(z.parent.parent);
//                }
//            }
//        }
//        // Color root black at all times
//        root.setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
//    }


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

//
//    public boolean exists(Comparable x){
//        return exists(root, x);
//    }
//
//    private boolean exists(RedBlackTreeNode<T> t, Comparable<T> x) {
//        if (t == null)
//            return false;
//
//        if (x.compareTo(t.getElement()) == 0)
//            return true;
//        else if (x.compareTo(t.getElement()) < 0)
//            return exists(t.getLeftChild(), x);
//        else
//            return exists(t.getRightChild(), x);
//    }

    void save() throws IOException {

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("RedBlackTree"));
        oos.writeObject(this);
        oos.close();

    }

    RedBlackTree<T> recover(String name) throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(name));

        RedBlackTree<T> a;
        a = (RedBlackTree<T>) ois.readObject();
        ois.close();
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