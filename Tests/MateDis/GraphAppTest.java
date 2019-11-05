package MateDis;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GraphAppTest {

    private GraphApp app = new GraphApp();

    @Test
    public void rdmGraphTest() {

        int order = 4;
        int alpha = 5;

        app.rdmGraph(order, alpha);
    }

    @Test
    public void printGraphTest(){

        int order = 7;
        int alpha = 1;

        WeightedGraph<Integer> g = app.rdmGraph(order, alpha);
        GraphApp.printGraph(g);
    }

    @Test
    public void flatSearch() {
        WeightedGraph<Integer> g = new WeightedGraph<>();
        g.insertVertex(0);
        g.insertVertex(3);
        g.insertVertex(2);
        g.insertVertex(1);
        g.insertVertex(4);
        g.insertVertex(5);
        g.insertEdge(2, 3, 567);
        g.insertEdge(3, 5, 345);
        g.insertEdge(0, 2, 234);

        app.flatSearch(g);
    }

    @Test
    public void DFSTest() {
        WeightedGraph<Integer> g = new WeightedGraph<>();
        g.insertVertex(0);
        g.insertVertex(3);
        g.insertVertex(2);
        g.insertVertex(1);
        g.insertVertex(4);
        g.insertVertex(5);
        g.insertEdge(2, 3, 567);
        g.insertEdge(3, 5, 345);
        g.insertEdge(0, 2, 234);

        app.DFS(g, 3);
    }

    @Test
    public void BFSTest() {
        WeightedGraph<Integer> g = new WeightedGraph<>();
        g.insertVertex(0);
        g.insertVertex(3);
        g.insertVertex(2);
        g.insertVertex(1);
        g.insertVertex(4);
        g.insertVertex(5);
        g.insertEdge(2, 3, 567);
        g.insertEdge(3, 5, 345);
        g.insertEdge(0, 2, 234);

        app.BFS(g, 3);
    }

    @Test
    public void primTest() {
        WeightedGraph<Integer> g = new WeightedGraph<>();
        g.insertVertex(0);
        g.insertVertex(1);
        g.insertVertex(2);
        g.insertVertex(3);
        g.insertVertex(4);
        g.insertVertex(5);
        g.insertEdge(0, 1, 5);
        g.insertEdge(0, 2, 6);
        g.insertEdge(0, 3, 1);
        g.insertEdge(1, 3, 5);
        g.insertEdge(1, 5, 2);
        g.insertEdge(2, 3, 5);
        g.insertEdge(2, 4, 3);
        g.insertEdge(3, 4, 6);
        g.insertEdge(3, 5, 4);
        g.insertEdge(4, 5, 6);

        List<Integer> expected = new ArrayList<>();
        expected.add(-1);
        expected.add(5);
        expected.add(3);
        expected.add(0);
        expected.add(2);
        expected.add(3);

        List<Integer> actual = app.prim(g, 0);
        for (int i = 0; i < expected.size(); i++) {
            assert actual.get(i).equals(expected.get(i));
        }
    }
}