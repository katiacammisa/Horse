package TP7;

import BinaryTree.BinaryTree;
import Queue.DynamicQueue;
import Queue.Queue;
import Queue.StaticQueue;

import java.util.ArrayList;
import java.util.List;

public class TreeApi<T> {


    //Ejercicio 13 a.
    public int size(BinaryTree a){
        if(a.isEmpty()){
            return 0;
        } else {
            return 1 + size(a.getRight())+ size(a.getLeft());
        }
    }

    //Ejercicio 13 b.
    public int leaves(BinaryTree a){
        if(a.getLeft().isEmpty() && a.getRight().isEmpty()){
            return 1;
        }
        return leaves(a.getLeft()) + leaves(a.getRight());
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


    //Ejercicio 13 c.
    public int occurrences(BinaryTree a, T o){
        if(a.isEmpty())
            return 0;
        if(a.getRoot().equals(o))
            return 1 + occurrences(a.getLeft(),o)+occurrences(a.getRight(),o);
        else
            return occurrences(a.getLeft(),o)+occurrences(a.getRight(),o);
    }

    //Ejercicio 13 d.
//    public DynamicQueue ElementsAtLevel(BinaryTree a, int level){
//        DynamicQueue<BinaryTree<T>> dq = new DynamicQueue<BinaryTree<T>>();
//        //todo fijarse que level no se mayor a los niveles totales.
//        dq.enqueue(a); // nivel 1
//
//        while (level > 0) {
//            if (!dq.peek().getLeft().isEmpty())
//                dq.enqueue(dq.peek().getLeft());
//            if (!dq.peek().getRight().isEmpty())
//                dq.enqueue(dq.peek().getRight());
//            else if (dq.peek().getRight().isEmpty() && dq.peek().getLeft().isEmpty())
//                dq.dequeue();
//            level--;
//        }
//        return dq;
//    }

    public boolean belongs(BinaryTree a, T o) {
        return occurrences(a, o) >= 1;
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

    //Ejercicio 13 e.
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

    public void print(BinaryTree a){
        if(!a.isEmpty()){
            print(a.getLeft());
            System.out.println(a.getRoot());
            print(a.getRight());
        }
    }

    public boolean equals(BinaryTree a, BinaryTree b){
        if(size(a) != size(b)){
            return false;
        }
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

    public boolean full(BinaryTree a) {
        if(complete(a)){
            if(size(a) == (Math.pow(2, height(a) + 1) - 1)) {
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean aux(BinaryTree<T> a, BinaryTree<T> b){
        if (!a.isEmpty()){
            if (!belongs(b, a.getRoot()))
                return false;
            if (!a.getLeft().isEmpty() && !a.getRight().isEmpty())
                return true;
            return aux(a.getRight(), b) && aux(a.getLeft(), b);
        }
        return b.isEmpty();
    }

    public boolean similar(BinaryTree<T> a, BinaryTree<T> b) {
        if(size(a) != size(b)) {
            return false;
        }
        return aux(a, b);
    }
//    public boolean stable(BinaryTree<Comparable> a){
//        if(a.isEmpty() || size(a) == 1 || inOrder(a)){
//            return true;
//        }
//        return false;
//    }

    public List getElements(BinaryTree a, List arr) {
        if (!a.isEmpty()) {
            getElements(a.getLeft(), arr);
            arr.add(a.getRoot());
            getElements(a.getRight(), arr);
        }
        return arr;
    }
//
//    private boolean inOrder(BinaryTree a){
//        if(a.isEmpty()){
//            return true;
//        }
//        if(a.getRoot() <  )
//    }

    public List<BinaryTree> frontier(BinaryTree a){
        List<BinaryTree> list = new ArrayList<BinaryTree>();
        if(a.getLeft().isEmpty() && a.getRight().isEmpty()){
            list.add(a);
        }
        if (!a.getRight().isEmpty()){
            list.addAll(frontier(a.getRight()));
        }
        if(!a.getLeft().isEmpty()){
            list.addAll(frontier(a.getLeft()));
        }
        return list;
    }


    public void showFrontier(BinaryTree a){
        List<BinaryTree> list = frontier(a);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getRoot());
        }
    }
    private boolean comparator(BinaryTree<T> a, BinaryTree<T> b){
        if (!a.isEmpty()){
            if (!belongs(b, a.getRoot()))
                return false;
            if (!a.getLeft().isEmpty() && !a.getRight().isEmpty())
                return true;
            return comparator(a.getRight(), b) && comparator(a.getLeft(), b);
        }
        return b.isEmpty();
    }

    public boolean similar(BinaryTree<T> a, BinaryTree<T> b) {
        if(size(a) != size(b)) {
            return false;
        }
        return comparator(a, b);
    }

    public boolean happensInB(BinaryTree<T> a, BinaryTree<T> b) {
        if(b.isEmpty()) {
            return true;
        }

        if(equals(a, b)) {
            return true;
        }

        if(size(b) < size(a)) {
            return happensInB(a.getRight(), b) || happensInB(a.getLeft(), b);
        } else {
            return false;
        }
    }
}
