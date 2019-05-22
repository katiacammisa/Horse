package TpRojinegro;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RedBlackTreeTest extends Assert {

    RedBlackTree tree = new RedBlackTree();

    @Test
    public void print() {
        tree.insert(12);                    // no anda
        System.out.println("hola");
    }
}