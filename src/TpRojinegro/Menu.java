package TpRojinegro;

import Interfaces.Comparable;

import java.util.Scanner;

public class Menu {

    public RedBlackTree<book> tree;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while(n != 7){
            System.out.println("Enter 1 to insert a book. \n" +
                    "Enter 2 to delete a book \n" +
                    "Enter 3 to modify something about a book \n" +
                    "Enter 4 for Consults \n" +
                    "Enter 5 for reports \n" +
                    "Enter 6 to save tree \n" +
                    "Enter 7 to exit.");
            n = scanner.nextInt();
            //Faltan los cases, dio demasiada paja en este momento
        }

    }

    private void insert(book element){
        tree.insert(element);
    }

    private void delete(book element){
        tree.delete(element);
    }

    private void modifyTitle(book toModify, String newTitle){
        tree.search(toModify).setTitle(newTitle);
    }

    private void modifyAuthor(book toModify, String newAuthor){
        tree.search(toModify).setAuthor(newAuthor);
    }

    private void modifyCode(book toModify, long newCode){
        tree.search(toModify).setCode(newCode);
    }

    private Object[] findElement(int key){
        return null; //No se como hacer esto, por ahi podemos copiar el search y cambiar un par de cosas y listo
    }

    private int amountOfElements(){
        return tree.size();
    }

    private int amountOfElementWithCondition(){
        return 0; // -\(. _ .)/-
    }

    private void showEveryElement(){
        tree.print();
    }

    private void showElementsWithCondition(){
        // -\(. _ .)/-
    }







}
