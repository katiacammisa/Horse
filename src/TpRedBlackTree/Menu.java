package TpRedBlackTree;

import java.io.IOException;
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
        } else if(doesNotExist(tree, element.getKey())){
            System.out.println(tree.getRootNode().getElement().getKey());
            tree.insert(element);
        }
    }

    void delete(Book element) {
        if(tree.isEmpty()) {
            System.out.println("The tree is empty.");
        } else {
            tree.delete(Objects.requireNonNull(search(element.getKey())));
        }
    }

    void modifyTitle(Book toModify, String newTitle) {
        tree.search(toModify).getElement().setTitle(newTitle);
    }

    void modifyAuthor(Book toModify, String newAuthor) {
        tree.search(toModify).getElement().setAuthor(newAuthor);
    }

    void modifyCode(Book toModify, long newCode) {
        tree.search(toModify).getElement().setCode(newCode);
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

            if (node.getElement() != null && node.getColor() != null) {
                String output = "Node at level " + level + ". Key: " + node.getElement().toString() + ". Color: "
                        + node.getColor().toString() + ". Type child: " + typeChild + ". Parent: "
                        + node.getParent().getElement();
                System.out.println(output);
            }

            if (node.getRightChild() != null) {
                printInOrderAllNodes(node.getRightChild(), level + 1, "right child");
            }
        }
    }

    void save() {
        try {
            tree.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean doesNotExist(RedBlackTree<Book> a, int x){
        return !exists(a.getRootNode(),x);
    }

    private boolean exists(RedBlackTreeNode<Book> t, Integer x) {
        if (t == null || t.getElement() == null)
            return false;

        if (x.compareTo(t.getElement().getKey()) == 0)
            return true;
        else if (x.compareTo( t.getElement().getKey()) < 0)
            return exists(t.getLeftChild(), x);
        else
            return exists(t.getRightChild(), x);
    }

    void recover() {
        try {
           tree =  tree.recover("RedBlackTree");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    Book findElement(int key) {
        if(doesNotExist(tree, key)) {
            throw new RuntimeException("The Book doesn't exist");
        }
        return Objects.requireNonNull(search(key)).getElement();
    }

    private RedBlackTreeNode<Book> search(int key) {
        RedBlackTreeNode<Book> x = tree.getRootNode();
        while (!x.equals(tree.getNilNode())) {
            if (x.getElement().getKey() == key) {
                return x;
            } else if (x.getElement().getKey() > key) {
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
        if(finalList.isEmpty()){
            return "There are no books with that Title.";
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
        if(finalList.isEmpty()){
            return "There are no books with that Author.";
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
        if(finalList.isEmpty()){
            return "There are no books with that Code.";
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