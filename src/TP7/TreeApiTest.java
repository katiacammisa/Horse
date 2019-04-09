package TP7;

import BinaryTree.BinaryTree;
import org.junit.Test;

public class TreeApiTest {

    BinaryTree<Integer> x = new BinaryTree<Integer>(5);
    BinaryTree<Integer> y = new BinaryTree<Integer>(6);
    BinaryTree<Integer> a = new BinaryTree<Integer>(8,x,y);
    BinaryTree<Integer> d = new BinaryTree<Integer>(8,x,y);
    BinaryTree<Integer> b = new BinaryTree<Integer>(5, y, x);
    BinaryTree<Integer> c = new BinaryTree<Integer>(2, a, y);

    TreeApi<Integer> api = new TreeApi<>();

    @Test
    public void leafs() {
        System.out.println("Leaves: " + api.leaves(a));
        System.out.println("Level: " + api.level(a,6));
        System.out.println(api.elementsInLevel(a,1));
        System.out.println("Equals: " + api.equals(a, b));
        System.out.println("Isomorphic: " + api.isomorphicTrees(a, b));
        System.out.println(api.isomorphicTrees(a, x));
        System.out.println("Complete: " + api.complete(c));

        System.out.println(api.complete(c));
        System.out.println(api.height(a));
        System.out.println(api.full(a));
        System.out.println(api.similar(a, d));

    }
}