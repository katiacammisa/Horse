package TP7;

import BinaryTree.BinaryTree;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println("Leaves: " + api.leaves(a)); // 2

        System.out.println("Level: " + api.level(a,6)); // 1
        System.out.println(api.elementsInLevel(a,1)); // 0

        System.out.println("Equals: " + api.equals(a, b)); // equals

        System.out.println("Isomorphic: " + api.isomorphicTrees(a, b)); // true
        System.out.println(api.isomorphicTrees(a, x)); // false

        System.out.println("Complete: " + api.complete(c)); // true
        System.out.println(api.complete(c)); // true

        System.out.println(api.height(a)); // 1

        System.out.println(api.full(a)); // true

        System.out.println(api.similar(a, d)); // true

        List<BinaryTree> list = api.frontier(a);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getRoot()); // 6,5
        }

        System.out.println(api.full(c)); // false

        System.out.println(api.similar(a, d)); // true

        System.out.println("Happens: " + api.happensInB(c, b)); // false

        System.out.println(api.elementsAtLevel(a, 0)); // 1

        List<Integer> list3 = new ArrayList<Integer>();
        List<BinaryTree> list2 = api.inorden(a, list3);

        api.save(a);
        api.preorder(api.load());
    }
}