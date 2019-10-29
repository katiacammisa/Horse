package MateDis;

import org.junit.Test;

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
    public void primTest() {

    }

    @Test
    public void printGraphTest(){
        GraphApp app = new GraphApp();
        int order = 4;
        int alpha = 6;

        WeightedGraph g = app.rdmGraph(order, alpha);

        app.printGraph(g);
    }

}