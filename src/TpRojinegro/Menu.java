package TpRojinegro;

import java.util.Scanner;

public class Menu {

    private RedBlackTree<Book> tree;

    public static void main(String[] args) {


        /* FALTA:
                   2 CON CONDICION
                   SIZE


        */
        Book book = new Book(15, "Hola", "Katy", 12345);
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
                        break;
                    } else {
                        System.out.println("There already exists a book with this key");
                        break;
                    }

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
                            System.out.println(menu.amountOfElements());
                            break;

                        case 3:
                            System.out.println("Enter the condition");
                            String condition = scanner.next(); //CUAL PUEDE SER LA CONDICION?
                            System.out.println(menu.amountOfElementWithCondition(/*condicion*/));
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
                            menu.showElementsWithCondition();
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
            tree.delete(search(element));
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

    public Book findElement(int key) {
        if(!exists(tree, key)) {
            throw new RuntimeException("The Book doesn't exist");
        }
        return search(tree.getRootNode().getKey()).getKey();
    }

    public RedBlackTreeNode<Book> search(Book book) {
        RedBlackTreeNode<Book> x = tree.getRootNode();
        while (!x.equals(tree.getNilNode())) {
            if (x.getKey().equals(book)) {
                return x;
            } else if (x.getKey().compareTo(book) > 0) {
                x = x.getLeftChild();
            } else {
                x = x.getRightChild();
            }
        }
        return null;
    }
    private int amountOfElements() {
        return tree.size(tree);

    }

    private int amountOfElementWithCondition(/*condicion*/) {
        return 0; // -\(. _ .)/-
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

    private void showElementsWithCondition() {
        // -\(. _ .)/-
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
}
