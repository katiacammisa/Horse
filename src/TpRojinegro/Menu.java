package TpRojinegro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private RedBlackTree<Book> tree;

    public static void main(String[] args) {


        /* FALTA:
                   2 CON CONDICION
        */
        RedBlackTree tree = new RedBlackTree<>();
        Menu menu = new Menu(tree);

        if(!tree.isEmpty()) {
            menu.recover();
        }
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while(n != 7){
            System.out.println("Enter 1 to insert a book. \n" +
                    "Enter 2 to delete a Book \n" +
                    "Enter 3 to modify something about a book \n" +
                    "Enter 4 for consults \n" +
                    "Enter 5 for reports \n" +
                    "Enter 6 to save tree \n" +
                    "Enter 7 to exit.");
            n = scanner.nextInt();

            switch (n) {
                case 1:
                    System.out.println("Insert the Book's key");
                    int key = scanner.nextInt();

                    if(!menu.exists(tree,key)) {
                        System.out.println("Insert the Book's title");
                        String title = scanner.next();
                        System.out.println("Insert the Book's author");
                        String author = scanner.next();
                        System.out.println("Insert the Book's code");
                        long code = scanner.nextLong();

                        Book book2 = new Book(key, title, author, code);
                        menu.insert(book2);
                    } else {
                        System.out.println("There already exists a book with this key");
                    }
                    break;

                case 2:
                    System.out.println("Insert the book's key");
                    int delete = scanner.nextInt();
                    menu.delete(menu.findElement(delete));
                    break;

                case 3:
                    System.out.println("Insert the key of the book you want to modify");
                    int keyOfBook = scanner.nextInt();
                    Book bookToModify = menu.findElement(keyOfBook);
                    int i;
                    System.out.println("Enter 1 to change title. \n" +
                            "Enter 2 to change author. \n" +
                            "Enter 3 to change code");
                    i = scanner.nextInt();

                    switch (i) {
                        case 1:
                            System.out.println("Insert the new title");
                            String modifyTitle = scanner.next();
                            menu.modifyTitle(bookToModify, modifyTitle);
                            break;

                        case 2:
                            System.out.println("Insert the new author");
                            String modifyAuthor = scanner.next();
                            menu.modifyAuthor(bookToModify, modifyAuthor);
                            break;

                        case 3:
                            System.out.println("Insert the new code");
                            long modifyCode = scanner.nextLong();
                            menu.modifyCode(bookToModify, modifyCode);
                            break;
                    }
                    break;

                case 4:
                    int consult;
                    System.out.println("Enter 1 to show element. \n" +
                            "Enter 2 to show amount of elements. \n" +
                            "Enter 3 to show amount of elements with condition.");
                    consult = scanner.nextInt();

                    switch (consult) {
                        case 1:
                            System.out.println("Insert the key of the element.");
                            int elementToFind = scanner.nextInt();
                            Book bookToReturn = menu.findElement(elementToFind);
                            System.out.println(bookToReturn.getTitle() + ", " + bookToReturn.getAuthor() + ", " + bookToReturn.getCode());
                            break;

                        case 2:
                            if(!tree.isEmpty()) {
                                System.out.println(menu.amountOfElements());
                            } else {
                                System.out.println("The tree is empty.");
                            }
                            break;

                        case 3:
                            System.out.println("Enter 1 to look by title. \n" +
                                    "Enter 2 to look by author. \n" +
                                    "Enter 3 to look by code.");
                            int condition = scanner.nextInt();

                            switch (condition) {
                                case 1:
                                    System.out.println("Insert the title.");
                                    String lookByTitle = scanner.next();
                                    System.out.println(menu.amountOfElementWithTitleCondition(lookByTitle));
                                    break;

                                case 2:
                                    System.out.println("Insert the author.");
                                    String lookByAuthor = scanner.next();
                                    System.out.println(menu.amountOfElementWithAuthorCondition(lookByAuthor));
                                    break;

                                case 3:
                                    System.out.println("Insert the code.");
                                    long lookByCode = scanner.nextLong();
                                    System.out.println(menu.amountOfElementWithCodeCondition(lookByCode));
                                    break;

                            }
                            break;
                    }
                    break;

                case 5:
                    int inform;
                    System.out.println("Enter 1 to get all elements. \n" +
                            "Enter 2 to get all elements with condition.");
                    inform = scanner.nextInt();

                    switch (inform) {
                        case 1:
                            menu.showEveryElement();
                            break;

                        case 2:
                            System.out.println("Enter 1 to look by title. \n" +
                                    "Enter 2 to look by author. \n" +
                                    "Enter 3 to look by code.");
                            int condition = scanner.nextInt();

                            switch (condition) {
                                case 1:
                                    System.out.println("Insert the title.");
                                    String lookByTitle = scanner.next();
                                    System.out.println(menu.elementWithTitleCondition(lookByTitle));
                                    break;

                                case 2:
                                    System.out.println("Insert the author.");
                                    String lookByAuthor = scanner.next();
                                    System.out.println(menu.elementWithAuthorCondition(lookByAuthor));
                                    break;

                                case 3:
                                    System.out.println("Insert the code.");
                                    long lookByCode = scanner.nextLong();
                                    System.out.println(menu.elementWithCodeCondition(lookByCode));
                                    break;

                            }
                            break;
                    }
                    break;

                case 6:
                    menu.save();
                    break;

                case 7:
                    menu.save();
                    System.exit(0);
                    break;

            }
        }
    }

    public Menu(RedBlackTree<Book> tree2) {
        tree = tree2;
    }

    private void insert(Book element) {
        if(tree.isEmpty()) {
            tree = new RedBlackTree<>(element);
        } else {
            tree.insert(element);
        }
    }

    private void delete(Book element) {
        if(tree.isEmpty()) {
            System.out.println("The tree is empty.");
        } else {
            tree.delete(search(element.getKey()));
        }
    }

    private void modifyTitle(Book toModify, String newTitle) {
        tree.search(toModify).getKey().setTitle(newTitle);
    }

    private void modifyAuthor(Book toModify, String newAuthor) {
        tree.search(toModify).getKey().setAuthor(newAuthor);
    }

    private void modifyCode(Book toModify, long newCode) {
        tree.search(toModify).getKey().setCode(newCode);
    }

    private int amountOfElements() {
        return tree.size(tree);
    }

    private void showEveryElement() {
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

    private void save() {
        tree.save();
    }

    public boolean exists(RedBlackTree a, int x){
        return exists(a.getRootNode(), x);
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

    private void recover() {
        tree.recover();
    }

    public Book findElement(int key) {
        if(!exists(tree, key)) {
            throw new RuntimeException("The Book doesn't exist");
        }
        return search(key).getKey();
    }

    public RedBlackTreeNode<Book> search(int key) {
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

    private int amountOfElementWithTitleCondition(String title) {
        List<Book> aux = tree.toInOrderList();
        List<Book> finalList = new ArrayList<>();
        for (int i = 0; i < aux.size(); i++) {
            if(aux.get(i).getTitle().equals(title)) {
                finalList.add(aux.get(i));
            }
        }
        return (finalList.size());
    }

    private int amountOfElementWithAuthorCondition(String author) {
        List<Book> aux = tree.toInOrderList();
        List<Book> finalList = new ArrayList<>();
        for (int i = 0; i < aux.size(); i++) {
            if(aux.get(i).getAuthor().equals(author)) {
                finalList.add(aux.get(i));
            }
        }
        return (finalList.size());
    }

    private int amountOfElementWithCodeCondition(Long code) {
        List<Book> aux = tree.toInOrderList();
        List<Book> finalList = new ArrayList<>();
        for (int i = 0; i < aux.size(); i++) {
            if(aux.get(i).getCode() == code) {
                finalList.add(aux.get(i));
            }
        }
        return (finalList.size());
    }

    private String elementWithTitleCondition(String title) {
        List<Book> aux = tree.toInOrderList();
        List<Book> finalList = new ArrayList<>();
        for (int i = 0; i < aux.size(); i++) {
            if(aux.get(i).getTitle().equals(title)) {
                finalList.add(aux.get(i));
            }
        }
        return myToString(finalList);
    }

    private String elementWithAuthorCondition(String author) {
        List<Book> aux = tree.toInOrderList();
        List<Book> finalList = new ArrayList<>();
        for (int i = 0; i < aux.size(); i++) {
            if(aux.get(i).getAuthor().equals(author)) {
                finalList.add(aux.get(i));
            }
        }
        return myToString(finalList);
    }

    private String elementWithCodeCondition(Long code) {
        List<Book> aux = tree.toInOrderList();
        List<Book> finalList = new ArrayList<>();
        for (int i = 0; i < aux.size(); i++) {
            if(aux.get(i).getCode() == code) {
                finalList.add(aux.get(i));
            }
        }
        return myToString(finalList);
    }

    public String myToString(List<Book> list) {
        String aux = "";
        for (int i = 0; i < list.size(); i++) {
            aux += list.get(i).toString() + "\n";
        }
        return aux;
    }
}
