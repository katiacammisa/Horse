package TpRojinegro;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RedBlackTreeTest extends Assert {

    RedBlackTree a = new RedBlackTree(12);

    @Test
    public void insert() {
        a.insert(15);
        a.printInOrderAllNodes();
        a.delete(a.search(12));
        a.printInOrderAllNodes();
        System.out.println(a.size(a));
    }

}