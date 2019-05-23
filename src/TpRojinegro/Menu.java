package TpRojinegro;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Menu {

    RedBlackTree<Book> tree;

    Menu(RedBlackTree<Book> tree2) {
        tree = tree2;
    }

    void insert(Book element) {
        if(tree.isEmpty()) {
            tree = new RedBlackTree<>(element);
        } else {
            tree.insert(element);
        }
    }

    void delete(Book element) {
        if(tree.isEmpty()) {
            System.out.println("The tree is empty.");
        } else {
            tree.delete(search(element.getKey()));
        }
    }

    void modifyTitle(Book toModify, String newTitle) {
        tree.search(toModify).getKey().setTitle(newTitle);
    }

    void modifyAuthor(Book toModify, String newAuthor) {
        tree.search(toModify).getKey().setAuthor(newAuthor);
    }

    void modifyCode(Book toModify, long newCode) {
        tree.search(toModify).getKey().setCode(newCode);
    }

    int amountOfElements() {
        return tree.size(tree);
    }

    void showEveryElement() {
        if (tree.getRootNode() != null) {
            printInOrderAllNodes(tree.getRootNode(), 0, "root");
        } else {
            System.out.println("The RBT is empty");
        }
    }

    private void printInOrderAllNodes(RedBlackTreeNode<Book> node, int level, String typeChild) {
        if (node != null) {
            if (node.getLeftChild() != null) {
                printInOrderAllNodes(node.getLeftChild(), level + 1, "left child");
            }

            if (node.getKey() != null && node.getColor() != null) {
                String output = "Node at level " + level + ". Key: " + node.getKey().toString() + ". Color: "
                        + node.getColor().toString() + ". Type child: " + typeChild + ". Parent: "
                        + node.getParent().getKey();
                System.out.println(output);
            }

            if (node.getRightChild() != null) {
                printInOrderAllNodes(node.getRightChild(), level + 1, "right child");
            }
        }
    }

    void save() {
        tree.save();
    }

    boolean exists(RedBlackTree<Book> a, int x){
        return !exists(a.getRootNode(), x);
    }

    private boolean exists(RedBlackTreeNode<Book> t, Integer x) {
        if (t == null)
            return false;

        if (x.compareTo(t.getKey().getKey()) == 0)
            return true;
        else if (x.compareTo( t.getKey().getKey()) < 0)
            return exists(t.getLeftChild(), x);
        else
            return exists(t.getRightChild(), x);
    }

    void recover() {
        tree.recover();
    }

    Book findElement(int key) {
        if(exists(tree, key)) {
            throw new RuntimeException("The Book doesn't exist");
        }
        return Objects.requireNonNull(search(key)).getKey();
    }

    private RedBlackTreeNode<Book> search(int key) {
        RedBlackTreeNode<Book> x = tree.getRootNode();
        while (!x.equals(tree.getNilNode())) {
            if (x.getKey().getKey() == key) {
                return x;
            } else if (x.getKey().getKey() > key) {
                x = x.getLeftChild();
            } else {
                x = x.getRightChild();
            }
        }
        return null;
    }

    int amountOfElementWithTitleCondition(String title) {
        List<Book> aux = tree.toInOrderList();
        List<Book> finalList = new ArrayList<>();
        for (Book anAux : aux) {
            if (anAux.getTitle().equals(title)) {
                finalList.add(anAux);
            }
        }
        return (finalList.size());
    }

    int amountOfElementWithAuthorCondition(String author) {
        List<Book> aux = tree.toInOrderList();
        List<Book> finalList = new ArrayList<>();
        for (Book anAux : aux) {
            if (anAux.getAuthor().equals(author)) {
                finalList.add(anAux);
            }
        }
        return (finalList.size());
    }

    int amountOfElementWithCodeCondition(Long code) {
        List<Book> aux = tree.toInOrderList();
        List<Book> finalList = new ArrayList<>();
        for (Book anAux : aux) {
            if (anAux.getCode() == code) {
                finalList.add(anAux);
            }
        }
        return (finalList.size());
    }

    String elementWithTitleCondition(String title) {
        List<Book> aux = tree.toInOrderList();
        List<Book> finalList = new ArrayList<>();
        for (Book anAux : aux) {
            if (anAux.getTitle().equals(title)) {
                finalList.add(anAux);
            }
        }
        return myToString(finalList);
    }

    String elementWithAuthorCondition(String author) {
        List<Book> aux = tree.toInOrderList();
        List<Book> finalList = new ArrayList<>();
        for (Book anAux : aux) {
            if (anAux.getAuthor().equals(author)) {
                finalList.add(anAux);
            }
        }
        return myToString(finalList);
    }

    String elementWithCodeCondition(Long code) {
        List<Book> aux = tree.toInOrderList();
        List<Book> finalList = new ArrayList<>();
        for (Book anAux : aux) {
            if (anAux.getCode() == code) {
                finalList.add(anAux);
            }
        }
        return myToString(finalList);
    }

    private String myToString(List<Book> list) {
        String aux = "";
        for (Book aList : list) {
            aux += aList.toString() + "\n";
        }
        return aux;
    }
}
