package TpRojinegro;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        RedBlackTree<Book> tree = new RedBlackTree<>();
        Menu menu = new Menu(tree);

        if(!tree.isEmpty()) {
            menu.recover();
        }
        Scanner scanner = new Scanner(System.in);
        int n;
        while(true){
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

                    if(menu.exists(tree, key)) {
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
                            if(menu.tree.isEmpty()) {
                                System.out.println("The tree is empty.");
                            } else {
                                System.out.println(menu.amountOfElements());
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
}
