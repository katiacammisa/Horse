package TpRojinegro;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RedBlackTree2Test extends Assert {

    RedBlackTree2 a = new RedBlackTree2(12);

    @Test
    public void insert() {
        a.insert(15);
        a.printInOrderAllNodes();
        a.delete(a.search(12));
        a.printInOrderAllNodes();
    }

}