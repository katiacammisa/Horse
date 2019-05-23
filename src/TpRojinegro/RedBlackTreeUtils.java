package TpRojinegro;

import java.io.Serializable;

public class RedBlackTreeUtils<T extends Serializable> implements Serializable {

    static <T extends Comparable<T> & Serializable> void leftRotate(RedBlackTree<T> tree, RedBlackTreeNode<T> node) {
        RedBlackTreeNode<T> child = node.getRightChild();
        node.setRightChild(child.getLeftChild());
        if (child.getLeftChild() != tree.getNilNode()) {
            child.getLeftChild().setParent(node);
        }
        child.setParent(node.getParent());
        if (node.getParent() == tree.getNilNode()) {
            tree.setRootNode(child);
        } else if (node.equals(node.getParent().getLeftChild())) {
            node.getParent().setLeftChild(child);
        } else {
            node.getParent().setRightChild(child);
        }
        child.setLeftChild(node);
        node.setParent(child);
    }

    static <T extends Comparable<T> & Serializable> void rightRotate(RedBlackTree<T> tree, RedBlackTreeNode<T> node) {
        RedBlackTreeNode<T> child = node.getLeftChild();
        node.setLeftChild(child.getRightChild());
        if (child.getRightChild() != tree.getNilNode()) {
            child.getRightChild().setParent(node);
        }
        child.setParent(node.getParent());
        if (node.getParent() == tree.getNilNode()) {
            tree.setRootNode(child);
        } else if (node.equals(node.getParent().getLeftChild())) {
            node.getParent().setLeftChild(child);
        } else {
            node.getParent().setRightChild(child);
        }
        child.setRightChild(node);
        node.setParent(child);
    }

    static <T extends Comparable<T> & Serializable> void rbtInsertFixup(RedBlackTree<T> tree, RedBlackTreeNode<T> node) {
        while (node.getParent().getColor().equals(RedBlackTreeNode.RBT_COLORS.RED)) {
            if (node.getParent().equals(node.getParent().getParent().getLeftChild())) {
                RedBlackTreeNode<T> uncle = node.getParent().getParent().getRightChild();
                if (uncle.getColor().equals(RedBlackTreeNode.RBT_COLORS.RED)) {
                    node.getParent().setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
                    uncle.setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
                    node.getParent().getParent().setColor(RedBlackTreeNode.RBT_COLORS.RED);
                    node = node.getParent().getParent();
                } else {
                    if (node.equals(node.getParent().getRightChild())) {
                        node = node.getParent();
                        leftRotate(tree, node);
                    }
                    node.getParent().setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
                    node.getParent().getParent().setColor(RedBlackTreeNode.RBT_COLORS.RED);
                    rightRotate(tree, node.getParent().getParent());
                }
            } else {
                RedBlackTreeNode<T> uncle = node.getParent().getParent().getLeftChild();
                if (uncle.getColor().equals(RedBlackTreeNode.RBT_COLORS.RED)) {
                    node.getParent().setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
                    uncle.setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
                    node.getParent().getParent().setColor(RedBlackTreeNode.RBT_COLORS.RED);
                    node = node.getParent().getParent();
                } else {
                    if (node.equals(node.getParent().getLeftChild())) {
                        node = node.getParent();
                        rightRotate(tree, node);
                    }
                    node.getParent().setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
                    node.getParent().getParent().setColor(RedBlackTreeNode.RBT_COLORS.RED);
                    leftRotate(tree, node.getParent().getParent());
                }
            }
        }
        tree.getRootNode().setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
    }

    static <T extends Comparable<T> & Serializable> void rbtTransplant(RedBlackTree<T> tree, RedBlackTreeNode<T> oldNode,
                                                                       RedBlackTreeNode<T> newNode) {
        if (oldNode.getParent().equals(tree.getNilNode())) {
            tree.setRootNode(newNode);
        } else if (oldNode.equals(oldNode.getParent().getLeftChild())) {
            oldNode.getParent().setLeftChild(newNode);
        } else {
            oldNode.getParent().setRightChild(newNode);
        }
        newNode.setParent(oldNode.getParent());
    }

    /**
     * The delete fixup method to preserve the RBT properties
     *
     * @param tree
     *            The RBT
     * @param node
     *            The node to remove
     */
    static <T extends Comparable<T> & Serializable> void deleteFixup(RedBlackTree<T> tree, RedBlackTreeNode<T> node) {
        RedBlackTreeNode<T> x = tree.getNilNode();
        while (!node.equals(tree.getRootNode()) && node.getColor() == RedBlackTreeNode.RBT_COLORS.BLACK) {
            if (node.equals(node.getParent().getLeftChild())) {
                x = node.getParent().getRightChild();
                if (x.getColor() == RedBlackTreeNode.RBT_COLORS.RED) {
                    x.setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
                    node.getParent().setColor(RedBlackTreeNode.RBT_COLORS.RED);
                    leftRotate(tree, node.getParent());
                    x = node.getParent().getRightChild();
                }
                if (x.getLeftChild().getColor() == RedBlackTreeNode.RBT_COLORS.BLACK
                        && x.getRightChild().getColor() == RedBlackTreeNode.RBT_COLORS.BLACK) {
                    x.setColor(RedBlackTreeNode.RBT_COLORS.RED);
                    node = node.getParent();
                } else {
                    if (x.getRightChild().getColor() == RedBlackTreeNode.RBT_COLORS.BLACK) {
                        x.getLeftChild().setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
                        x.setColor(RedBlackTreeNode.RBT_COLORS.RED);
                        rightRotate(tree, x);
                        x = node.getParent().getRightChild();
                    }
                    x.setColor(node.getParent().getColor());
                    node.getParent().setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
                    x.getRightChild().setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
                    leftRotate(tree, node.getParent());
                    node = tree.getRootNode();
                }
            } else {
                x = node.getParent().getLeftChild();
                if (x.getColor() == RedBlackTreeNode.RBT_COLORS.RED) {
                    x.setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
                    node.getParent().setColor(RedBlackTreeNode.RBT_COLORS.RED);
                    rightRotate(tree, node.getParent());
                    x = node.getParent().getLeftChild();
                }
                if (x.getRightChild().getColor() == RedBlackTreeNode.RBT_COLORS.BLACK
                        && x.getLeftChild().getColor() == RedBlackTreeNode.RBT_COLORS.BLACK) {
                    x.setColor(RedBlackTreeNode.RBT_COLORS.RED);
                    node = node.getParent();
                } else {
                    if (x.getLeftChild().getColor() == RedBlackTreeNode.RBT_COLORS.BLACK) {
                        x.getRightChild().setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
                        x.setColor(RedBlackTreeNode.RBT_COLORS.RED);
                        leftRotate(tree, x);
                        x = node.getParent().getLeftChild();
                    }
                    x.setColor(node.getParent().getColor());
                    node.getParent().setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
                    x.getLeftChild().setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
                    rightRotate(tree, node.getParent());
                    node = tree.getRootNode();
                }
            }
        }
        node.setColor(RedBlackTreeNode.RBT_COLORS.BLACK);
    }
}
