package TP7;

import BinaryTree.BinaryTree;
import org.junit.Test;

public class TreeApiTest {

    BinaryTree<Integer> x = new BinaryTree<Integer>(5);
    BinaryTree<Integer> y = new BinaryTree<Integer>(6);
    BinaryTree<Integer> a = new BinaryTree<Integer>(8,x,y);
    BinaryTree<Integer> b = new BinaryTree<Integer>(5, y, x);
    BinaryTree<Integer> c = new BinaryTree<Integer>(2, a, y);

    TreeApi<Integer> api = new TreeApi<>();

    @Test
    public void leafs() {
        System.out.println(api.leafs(a));
        System.out.println(api.level(a,6));
        System.out.println(api.elementsInLevel(a,1));
        System.out.println(api.equals(a, a));
        System.out.println(api.isomorphicTrees(a, b));
        System.out.println(api.isomorphicTrees(a, x));
        System.out.println(api.complete(c));
        System.out.println(api.height(a));
        System.out.println(api.full(a));

    }
}