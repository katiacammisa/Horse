package TP7;

import BinaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class TreeApi<T> {

    public int size(BinaryTree a){
        if(a.isEmpty()){
            return 0;
        } else {
            return 1 + size(a.getRight())+ size(a.getLeft());
        }
    }

    public int leafs(BinaryTree a){
        if(a.getLeft().isEmpty() && a.getRight().isEmpty()){
            return 1;
        }
        return leafs(a.getLeft()) + leafs(a.getRight());
    }

    public int completeNodes(BinaryTree a){
        if(a.isEmpty()){
            return 0;
        }
        if(a.getLeft().isEmpty()){
            return completeNodes(a.getRight());
        }
        if(a.getRight().isEmpty()){
            return completeNodes(a.getLeft());
        }

        return 1+completeNodes(a.getLeft()) + completeNodes(a.getRight());
    }

    public int occurrences(BinaryTree a, T o){
        if(a.isEmpty())
            return 0;
        if(a.getRoot().equals(o))
            return 1 + occurrences(a.getLeft(),o)+occurrences(a.getRight(),o);
        else
            return occurrences(a.getLeft(),o)+occurrences(a.getRight(),o);
    }

    public int level(BinaryTree a, T element){
        if(occurrences(a, element) == 0){
            return 0;
        }
        if(occurrences(a, element) == 1){
            if(a.getRoot().equals(element)){
                return 0;
            }
            return 1 + level(a.getRight(), element) + level(a.getLeft(), element);
        }
        else{
            throw new RuntimeException("More than one level");
        }
    }

    public int elementsInLevel(BinaryTree<T> a, int level){
        if(a.isEmpty()){
            return 0;
        }
        if(level(a, a.getRoot()) == level){
            return 1;
        }
        return elementsInLevel(a.getLeft(), level) + elementsInLevel(a.getRight(), level);
    }

    public int height(BinaryTree a){
        if(a.isEmpty()) {
            return 0;
        }
        int aux = 0;
        while (elementsInLevel(a, aux) != 0) {
            aux++;
        }
        return aux;
    }

    public void inOrder(BinaryTree a){
        if(!a.isEmpty()){
            inOrder(a.getLeft());
            System.out.println(a.getRoot());
            inOrder(a.getRight());
        }
    }

    public boolean equals(BinaryTree a, BinaryTree b){
        if(a.isEmpty() && b.isEmpty()){
            return true;
        }
        if(a.getRoot().equals(b.getRoot())){
            return equals(a.getRight(), b.getRight()) && equals(a.getLeft(), b.getLeft());
        } else {
            return false;
        }
    }

    public boolean isomorphicTrees(BinaryTree a, BinaryTree b){
        if(a.isEmpty() && b.isEmpty()){
            return true;
        }
        if((a.isEmpty() && !b.isEmpty()) || (!a.isEmpty() && b.isEmpty())){
            return false;
        }
        return isomorphicTrees(a.getRight(), b.getRight()) && isomorphicTrees(a.getLeft(), b.getLeft());
    }

    public boolean complete(BinaryTree a){
        if(a.isEmpty() && size(a) == 0) {
            return false;
        }
        if(a.isEmpty()){
            return true;
        }
        if(a.getLeft().isEmpty()) {
            return a.getRight().isEmpty();
        }
        if(a.getRight().isEmpty()) {
            return a.getLeft().isEmpty();
        }
        return complete(a.getRight()) && complete(a.getLeft());
    }


    public int sum(BinaryTree<Integer> a) {
        if(a.isEmpty()) {
            return 0;
        } else {
            return a.getRoot() + sum(a.getRight()) + sum(a.getLeft());
        }
    }

    public int sumMultiplesOf3(BinaryTree<Integer> a) {
        if(a.isEmpty()){
            return 0;
        }
        if(a.getRoot()%3 == 0) {
           return a.getRoot() + sumMultiplesOf3(a.getRight()) + sumMultiplesOf3(a.getLeft());
        } else {
            return sumMultiplesOf3(a.getRight()) + sumMultiplesOf3(a.getLeft());
        }
    }

    public boolean full(BinaryTree<Integer> a) {
        if(complete(a)){
            if(size(a) == (Math.pow(2, height(a) + 1) - 1)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean similar(BinaryTree<Integer> a, BinaryTree<Integer> b) {
        return similar(a.)
    }

}
