package TpBinaryTree;

import BinaryTree.BinaryTree;
import TpBinaryTree.TreeApi;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TreeApiTest2{

    BinaryTree<String> g = new BinaryTree<String>("G");
    BinaryTree<String> k = new BinaryTree<String>("K");
    BinaryTree<String> l = new BinaryTree<String>("L");
    BinaryTree<String> w = new BinaryTree<String>("W");
    BinaryTree<String> z = new BinaryTree<String>("Z");
    BinaryTree<String> v = new BinaryTree<String>();
    BinaryTree<String> h = new BinaryTree<String>("H", v, k);
    BinaryTree<String> r = new BinaryTree<String>("R", w, v);
    BinaryTree<String> q = new BinaryTree<String>("Q", r, v);
    BinaryTree<String> p = new BinaryTree<String>("P", q, z);

    BinaryTree<String> f = new BinaryTree<String>("F",g,h);
    BinaryTree<String> d = new BinaryTree<String>("D",f,l);
    BinaryTree<String> a = new BinaryTree<String>("A",d, p);

    TreeApi<String> api = new TreeApi<>();

    @Test
    public void size() {
        assertEquals(12, api.size(a));
    }

    @Test
    public void leaves() {
        assertEquals(3, api.leaves(a));
    }
//
//    @Test
//    public void occurrences() {
//        assertEquals(1, api.occurrences(a, 6));
//    }
//
//    @Test
//    public void elementsAtLevel() {
//        assertEquals(2, api.elementsAtLevel(a, 1));
//    }
//
//    @Test
//    public void height() {
//        assertEquals(1, api.height(a));
//    }
//
//    @Test
//    public void sum() {
//        assertEquals(19, api.sum(a));
//    }
//
//    @Test
//    public void sumMultiplesOf3() {
//        assertEquals(6, api.sumMultiplesOf3(a));
//    }
//
//    @Test
//    public void equals() {
//        assertEquals(false,api.equals(a, b));
//    }

//    @Test
//    public void isomorphicTrees() {
//        assertEquals(true, api.isomorphicTrees(a, b));
//        assertEquals(false, api.isomorphicTrees(x, a));
//    }
//
//    @Test
//    public void similar() {
//        assertEquals(false, api.similar(a, b));
//    }
//
//    @Test
//    public void complete() {
//        assertEquals(true, api.complete(c));
//    }
//
//    @Test
//    public void full() {
//        assertEquals(true, api.full(a));
//    }
//
//    @Test
//    public void stable() {
//        assertEquals(true, api.stable(a));
//    }
//
//    @Test
//    public void happensInB() {
//        assertEquals(false, api.happensInB(c, b));
//    }

    @Test
    public void showFrontier() {
        System.out.println("Frontier:");
        api.showFrontier(a);
    }

    @Test
    public void frontier() {
        List<BinaryTree> list = api.frontier(a);
        System.out.println("Frontier:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getRoot());
        }
    }

    @Test
    public void preOrder() {
        System.out.println("PreOrder");
        api.preOrder(a);
    }

    @Test
    public void inOrder() {
        System.out.println("InOrder");
        api.inOrder(a);
    }

    @Test
    public void postOrder() {
        System.out.println("PostOrder");
        api.postOrder(a);
    }

    @Test
    public void levelOrder() {
        System.out.println("LevelOrder");
        api.levelOrder(a);
    }

    @Test
    public void save() {
        api.save(a);
    }
}