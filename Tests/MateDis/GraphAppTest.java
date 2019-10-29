package MateDis;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class GraphAppTest {

    GraphApp app = new GraphApp();

    @Test
    public void rdmGraphTest() {

        int order = 4;
        int alpha = 5;

        app.rdmGraph(order, alpha);
    }

    @Test
    public void primTest() {

    }

    @Test
    public void printGraphTest(){

        int order = 7;
        int alpha = 1;

        WeightedGraph g = app.rdmGraph(order, alpha);
        GraphApp.printGraph(g);
    }

    @Test
    public void DFSTest() {
        WeightedGraph g = new WeightedGraph();
        g.insertVertex(0);
        g.insertVertex(3);
        g.insertVertex(2);
        g.insertVertex(1);
        g.insertVertex(4);
        g.insertVertex(5);
        g.insertEdge(2, 3, 567);
        g.insertEdge(3, 5, 345);
        g.insertEdge(0, 2, 234);

        GraphApp.printGraph(g);

        app.DFS(g, 3);
        app.flatSearch(g);
    }

    @Test
    public void BFSTest() {
        WeightedGraph g = new WeightedGraph();
        g.insertVertex(0);
        g.insertVertex(3);
        g.insertVertex(2);
        g.insertVertex(1);
        g.insertVertex(4);
        g.insertVertex(5);
        g.insertEdge(2, 3, 567);
        g.insertEdge(3, 5, 345);
        g.insertEdge(0, 2, 234);

        GraphApp.printGraph(g);

        app.BFS(g, 3);
    }

}