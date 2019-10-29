package MateDis;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class GraphAppTest {

    @Test
    public void rdmGraphTest() {

        GraphApp app = new GraphApp();
        int order = 4;
        int alpha = 4;

        app.rdmGraph(order, alpha);
    }



    @Test
    public void test() {

    }

    @Test
    public void printGraphTest(){
        GraphApp app = new GraphApp();
        int order = 7;
        int alpha = 1;

        WeightedGraph g = app.rdmGraph(order, alpha);
        app.printGraph(g);
    }

}