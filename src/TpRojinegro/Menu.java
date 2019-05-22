package TpRojinegro;

import Interfaces.Comparable;
import Nodes.DoubleNodeRB;

import java.util.Scanner;

public class Menu {

    public RedBlackTree<Book> tree;

    public static void main(String[] args) {

        RedBlackTree tree2 = new RedBlackTree<>();
        Menu menu = new Menu(tree2);

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
            //Faltan los cases, dio demasiada paja en este momento

            switch (n) {
                case 1:
                    System.out.println("Insert the Book's key");
                    int key = scanner.nextInt();
                    System.out.println("Insert the Book's title");
                    String title = scanner.next();
                    System.out.println("Insert the Book's author");
                    String author = scanner.next();
                    System.out.println("Insert the Book's code");
                    long code = scanner.nextLong();

                    Book book = new Book(key, title, author, code);
                    menu.insert(book);
                    break;

                case 2:
                    System.out.println("Insert the book's key");
                    int delete = scanner.nextInt();
                    menu.delete(menu.findElement(delete)); // NO ANDA EL FIND ELEMENT
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
                            String modifyTitile = scanner.next();
                            menu.modifyTitle(bookToModify, modifyTitile);
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
                    System.exit(0);
                    break;

            }
        }
    }

    public Menu(RedBlackTree<Book> tree) {
        this.tree = tree;
    }

    private void insert(Book element) {
        tree.insert(element);
    }

    private void delete(Book element) {
        tree.delete(element);
    }

    private void modifyTitle(Book toModify, String newTitle) {
        tree.search(toModify).setTitle(newTitle);
    }

    private void modifyAuthor(Book toModify, String newAuthor) {
        tree.search(toModify).setAuthor(newAuthor);
    }

    private void modifyCode(Book toModify, long newCode) {
        tree.search(toModify).setCode(newCode);
    }

    private Book findElement(int key) {return null;}
    //No se como hacer esto, por ahi podemos copiar el search y cambiar un par de cosas y listo
//    public Book search (Comparable key){
//        if (!tree.exists(key)) {
//            throw new RuntimeException("The Book doesn't exist");          ////////NO
//        }                                                                  ////////NO
//        return search((Book)tree.getRoot(), key).element;                  ////////NO
//                                                                           ////////NO
//    }                                                                      ////////NO
//    private DoubleNodeRB<Book> search(RedBlackTree<Book> t, Comparable x){ ////////NO
//        if (x.compareTo(t.data)== 0)                                       ////////NO
//            return t;                                                      ////////NO
//        else if (x.compareTo( t.data)< 0)                                  ////////NO
//            return search(t.left, x);                                      ////////NO
//        else                                                               ////////NO
//            return search(t.right, x);                                     ////////NO
//    }                                                                      ////////NO

    private int amountOfElements() {
        return tree.size();
    }

    private int amountOfElementWithCondition(/*condicion*/) {
        return 0; // -\(. _ .)/-
    }

    private void showEveryElement() {
        tree.print();
    }

    private void showElementsWithCondition() {
        // -\(. _ .)/-
    }

    private void save() {
        tree.save();
    }







}
