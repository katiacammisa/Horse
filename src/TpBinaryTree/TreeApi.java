package TpBinaryTree;

import BinaryTree.BinaryTree;
import Queue.DynamicQueue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TreeApi<T extends Serializable & Comparable> implements Serializable {

    //EJERCICIO 13
    //a
    public int size(BinaryTree a) {
        if (a.isEmpty()) {
            return 0;
        } else {
            return 1 + size(a.getRight()) + size(a.getLeft());
        }
    }

    //b
    public int leaves(BinaryTree a) {
        if(a.isEmpty()){
            return 0;
        }
        if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            return 1;
        }
        if(a.getLeft().isEmpty() || a.getRight().isEmpty()){
            return 0;
        }
        return leaves(a.getLeft()) + leaves(a.getRight());
    }

    //c
    public int occurrences(BinaryTree a, T o) {
        if (a.isEmpty())
            return 0;
        if (a.getRoot().equals(o))
            return 1 + occurrences(a.getLeft(), o) + occurrences(a.getRight(), o);
        else
            return occurrences(a.getLeft(), o) + occurrences(a.getRight(), o);
    }

    //d
    public int elementsAtLevel(BinaryTree a, int level) {
        if (a.isEmpty()) {
            return 0;
        }
        if (level == 0) {
            return 1;
        }
        return elementsAtLevel(a.getLeft(), level - 1) + elementsAtLevel(a.getRight(), level - 1);
    }

    //e
    public int height(BinaryTree a) {
        if (a.isEmpty()) {
            return -1;
        }
        int aux = 0;
        while (elementsInLevel(a, aux) != 0) {
            aux++;
        }
        return aux;
    }

    //EJERCICIO 14
    //a
        //i
    public int sum(BinaryTree<Integer> a) {
        if (a.isEmpty()) {
            return 0;
        } else {
            return a.getRoot() + sum(a.getRight()) + sum(a.getLeft());
        }
    }

        //ii
    public int sumMultiplesOf3(BinaryTree<Integer> a) {
        if (a.isEmpty()) {
            return 0;
        }
        if (a.getRoot() % 3 == 0) {
            return a.getRoot() + sumMultiplesOf3(a.getRight()) + sumMultiplesOf3(a.getLeft());
        } else {
            return sumMultiplesOf3(a.getRight()) + sumMultiplesOf3(a.getLeft());
        }
    }

    //b
        //i
    public boolean equals(BinaryTree a, BinaryTree b) {
        if (size(a) != size(b)) {
            return false;
        }
        if (a.isEmpty() && b.isEmpty()) {
            return true;
        }
        if (a.getRoot().equals(b.getRoot())) {
            return equals(a.getRight(), b.getRight()) && equals(a.getLeft(), b.getLeft());
        } else {
            return false;
        }
    }

        //ii
    public boolean isomorphicTrees(BinaryTree a, BinaryTree b) {
        if (a.isEmpty() && b.isEmpty()) {
            return true;
        }
        if ((a.isEmpty() && !b.isEmpty()) || (!a.isEmpty() && b.isEmpty())) {
            return false;
        }
        return isomorphicTrees(a.getRight(), b.getRight()) && isomorphicTrees(a.getLeft(), b.getLeft());
    }

        //iii
    public boolean similar(BinaryTree<T> a, BinaryTree<T> b) {
        if (size(a) != size(b)) {
            return false;
        }
        return comparator(a, b);
    }

        //iv
    public boolean complete(BinaryTree a) {
        if (a.isEmpty()) {
            return false;
        }
        if(a.getLeft().isEmpty() && a.getRight().isEmpty()){
            return true;
        }
        if (a.getLeft().isEmpty()) {
            return a.getRight().isEmpty();
        }
        if (a.getRight().isEmpty()) {
            return a.getLeft().isEmpty();
        }
        return complete(a.getRight()) && complete(a.getLeft());
    }

        //v
    public boolean full(BinaryTree a) {
        if (complete(a)) {
            if (size(a) == (Math.pow(2, height(a) + 1) - 1)) {
                return true;
            }
            return false;
        }
        return false;
    }

        //vi
    public boolean stable(BinaryTree<T> a) {
        if (a.isEmpty() || size(a) == 1) {
            return true;
        }
        if (a.getRoot().compareTo(a.getLeft().getRoot()) < 0 || a.getRoot().compareTo(a.getRight().getRoot()) < 0) {
            return false;
        }
        return stable(a.getRight()) && stable(a.getLeft());
    }

        //vii
    public boolean happensInB(BinaryTree<T> a, BinaryTree<T> b) {
        if (b.isEmpty()) {
            return true;
        }

        if (equals(a, b)) {
            return true;
        }

        if (size(b) < size(a)) {
            return happensInB(a.getRight(), b) || happensInB(a.getLeft(), b);
        } else {
            return false;
        }
    }

        //viii
    public void showFrontier(BinaryTree a) {
        List<BinaryTree> list = frontier(a);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getRoot());
        }
    }

        //ix
    public List<BinaryTree> frontier(BinaryTree a) {
        List<BinaryTree> list = new ArrayList<BinaryTree>();
        if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
            list.add(a);
        }
        if (!a.getRight().isEmpty()) {
            list.addAll(frontier(a.getRight()));
        }
        if (!a.getLeft().isEmpty()) {
            list.addAll(frontier(a.getLeft()));
        }
        return list;
    }

    //preorder
    public void preOrder(BinaryTree<T> a) {
        if (!a.isEmpty()) {
            System.out.println(a.getRoot());
            preOrder(a.getLeft());
            preOrder(a.getRight());
        }
    }

    //inorder
    public void inOrder(BinaryTree a) {
        if (!a.isEmpty()) {
            inOrder(a.getLeft());
            System.out.println(a.getRoot());
            inOrder(a.getRight());
        }
    }

    //postorder
    public void postOrder(BinaryTree<T> a) {
        if (!a.isEmpty()) {
            preOrder(a.getLeft());
            preOrder(a.getRight());
            System.out.println(a.getRoot());
        }
    }

    //levelOrder
    public void levelOrder(BinaryTree<T> a) {
        DynamicQueue<BinaryTree<T>> queue = new DynamicQueue<BinaryTree<T>>();
        List<T> list = new ArrayList();
        queue.enqueue(a);
        while (!queue.isEmpty()) {
            if (!queue.peek().getRight().isEmpty()) {
                queue.enqueue(queue.peek().getRight());
            }
            if (!queue.peek().getLeft().isEmpty()) {
                queue.enqueue(queue.peek().getLeft());
            }
            list.add(queue.peek().getRoot());
            queue.dequeue();
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    //Save in disk
    public void save(BinaryTree<T> a) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Hola"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Retrieve form disk
    public BinaryTree retrieve() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Hola"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BinaryTree a = null;
        try {
            a = (BinaryTree) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }

    //fin del tp

    public int completeNodes(BinaryTree a) {
        if (a.isEmpty()) {
            return 0;
        }
        if (a.getLeft().isEmpty()) {
            return completeNodes(a.getRight());
        }
        if (a.getRight().isEmpty()) {
            return completeNodes(a.getLeft());
        }

        return 1 + completeNodes(a.getLeft()) + completeNodes(a.getRight());
    }

    public boolean belongs(BinaryTree a, T o) {
        return occurrences(a, o) >= 1;
    }

    public int level(BinaryTree a, T element) {
        if (occurrences(a, element) == 0) {
            return 0;
        }
        if (occurrences(a, element) == 1) {
            if (a.getRoot().equals(element)) {
                return 0;
            }
            return 1 + level(a.getRight(), element) + level(a.getLeft(), element);
        } else {
            throw new RuntimeException("More than one level");
        }
    }

    public int elementsInLevel(BinaryTree<T> a, int level) {
        if (a.isEmpty()) {
            return 0;
        }
        if (level(a, a.getRoot()) == level) {
            return 1;
        }
        return elementsInLevel(a.getLeft(), level) + elementsInLevel(a.getRight(), level);
    }


    public List getElements(BinaryTree a, List arr) {
        if (!a.isEmpty()) {
            getElements(a.getLeft(), arr);
            arr.add(a.getRoot());
            getElements(a.getRight(), arr);
        }
        return arr;
    }

    private boolean comparator(BinaryTree<T> a, BinaryTree<T> b) {
        if (!a.isEmpty()) {
            if (!belongs(b, a.getRoot()))
                return false;
            if (!a.getLeft().isEmpty() && !a.getRight().isEmpty())
                return true;
            return comparator(a.getRight(), b) && comparator(a.getLeft(), b);
        }
        return b.isEmpty();
    }

    public List inorden(BinaryTree<T> a, List<T> list) {
        if (!a.isEmpty()) {
            inorden(a.getLeft(), list);
            list.add(a.getRoot());
            inorden(a.getRight(), list);
        }
        return list;
    }

//    public void levelOrder2(BinaryTree<T> a) {
//        int level = 0;
//        DynamicQueue<BinaryTree<T>> queue = new DynamicQueue<BinaryTree<T>>();
//        DynamicQueue<T> queue2 = new DynamicQueue<T>();
//        queue.enqueue(a);
//        while (!queue.isEmpty()) {
//            if (!queue.peek().getRight().isEmpty()) {
//                queue.enqueue(queue.peek().getRight());
//            }
//            if (!queue.peek().getLeft().isEmpty()) {
//                queue.enqueue(queue.peek().getLeft());
//            }
//            queue2.enqueue(queue.peek().getRoot());
//            queue.dequeue();
//        }
//        while(level < height(a)) {
//            if(level != 0) {
//                System.out.println(" ");
//            }
//            System.out.println("Level " + level + ": ");
//        }
//        for (int i = 0; i < elementsInLevel(a, level); i++) {
//            System.out.println(queue2.peek() + " ");
//            queue2.dequeue();
//        }
//        level++;
//    }
}