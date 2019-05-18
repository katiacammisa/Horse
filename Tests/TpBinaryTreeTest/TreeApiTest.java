package TpBinaryTree;

import BinaryTree.BinaryTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TreeApiTest extends Assert {

    BinaryTree<Integer> x = new BinaryTree<Integer>(5);
    BinaryTree<Integer> y = new BinaryTree<Integer>(6);
    BinaryTree<Integer> a = new BinaryTree<Integer>(8,x,y);
    BinaryTree<Integer> d = new BinaryTree<Integer>(8,x,y);
    BinaryTree<Integer> b = new BinaryTree<Integer>(5, y, x);
    BinaryTree<Integer> c = new BinaryTree<Integer>(2, a, y);

    TreeApi<Integer> api = new TreeApi<>();

    @Test
    public void size() {
        assertEquals(3, api.size(a));
    }

    @Test
    public void leaves() {
        assertEquals(2, api.leaves(a));
    }

    @Test
    public void occurrences() {
        assertEquals(1, api.occurrences(a, 6));
    }

    @Test
    public void datasAtLevel() {
        assertEquals(2, api.elementsAtLevel(a, 1));
    }

    @Test
    public void height() {
        assertEquals(1, api.height(a));
    }

    @Test
    public void sum() {
        assertEquals(19, api.sum(a));
    }

    @Test
    public void sumMultiplesOf3() {
        assertEquals(6, api.sumMultiplesOf3(a));
    }

    @Test
    public void equals() {
        assertEquals(false,api.equals(a, b));
    }

    @Test
    public void isomorphicTrees() {
        assertEquals(true, api.isomorphicTrees(a, b));
        assertEquals(false, api.isomorphicTrees(x, a));
    }

    @Test
    public void similar() {
        assertEquals(false, api.similar(a, b));
    }

    @Test
    public void complete() {
        assertEquals(true, api.complete(c));
    }

    @Test
    public void full() {
        assertEquals(true, api.full(a));
    }

    @Test
    public void stable() {
        assertEquals(true, api.stable(a));
    }

    @Test
    public void happensInB() {
        assertEquals(false, api.happensInB(c, b));
    }

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

    @Test
    public void retrieve() {
        api.retrieve();
    }
}