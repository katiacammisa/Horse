package MateDis;

import Queue.DynamicQueue;
import Stack.Stack;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class GraphApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter graph size.");
//        int size = scanner.nextInt();
        WeightedGraph<Integer> g = new WeightedGraph<>(/*size*/);
        int n;
        while (true) {
            System.out.println("Enter 1 to insert vertex. \n" +
                                "Enter 2 to insert edge. \n" +
                                "Enter 3 to delete vertex. \n" +
                                "Enter 4 to delete edge. \n" +
                                "Enter 5 to get cost of edge. \n" +
                                "Enter 6 to get adjacent list of edge. \n" +
                                "Enter 7 to print graph. \n" +
                                "Enter 8 to get the graph's order. \n" +
                                "Enter 9 to get the amount of edges. \n" +
                                "Enter 10 to exit.");

            n = scanner.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Insert the vertex.");
                    int s = scanner.nextInt();
                    if(!g.existsVertex(s)) {
                        g.insertVertex(s);
                    } else {
                        System.out.println("This vertex already exists.");
                    }
                    break;
                case 2:
                    System.out.println("Insert the first vertex.");
                    int v1 = scanner.nextInt();
                    System.out.println("Insert the second vertex.");
                    int v2 = scanner.nextInt();
                    System.out.println("Insert the cost.");
                    int cost = scanner.nextInt();
                    if(!g.existsEdge(v1, v2)) {
                        g.insertEdge(v1, v2, cost);
                    } else {
                        System.out.println("This edge already exists.");
                    }
                    break;
                case 3:
                    System.out.println("Insert the first vertex of the edge to delete.");
                    int del1 = scanner.nextInt();
                    System.out.println("Insert the second vertex of the edge to delete.");
                    int del2 = scanner.nextInt();
                    if (g.existsEdge(del1, del2)) {
                        g.deleteEdge(del1, del2);
                    } else {
                        System.out.println("This edge doesn't exist.");
                    }
                    break;
                case 4:
                    System.out.println("Insert the vertex to delete.");
                    int del = scanner.nextInt();
                    if(g.existsVertex(del)) {
                        g.deleteVertex(del);
                    } else {
                        System.out.println("This vertex doesn't exist.");
                    }
                    break;
                case 5:
                    System.out.println("Insert the first vertex of the edge to get cost");
                    int c1 = scanner.nextInt();
                    System.out.println("Insert the first vertex of the edge to get cost");
                    int c2 = scanner.nextInt();
                    if (g.existsEdge(c1, c2)) {
                        System.out.println(g.getCost(c1, c2));
                    } else {
                        System.out.println("This edge doesn't exist.");
                    }
                    break;
                case 6:
                    System.out.println("Insert the vertex to get adj list.");
                    int adj = scanner.nextInt();
                    if (g.existsVertex(adj)) {
                        System.out.println(g.getAdjList(adj).toString());
                    } else {
                        System.out.println("This vertex doesn't exist");
                    }
                    break;
                case 7:
                    printGraph(g);
                    break;
                case 8:
                    System.out.println("The graphs order is: " + g.order() + ".");
                    break;
                case 9:
                    System.out.println("The graph has: " + g.edgeAmount() + " edges.");
                    break;
                case 10:
                    System.exit(0);
                    break;
            }
        }
    }

    WeightedGraph<Integer> rdmGraph(int order, int alpha){
        if(alpha > ((order*(order-1))/2)){
            throw new IllegalArgumentException("This alpha should be <= " + order*(order-1)/2);
        }

        WeightedGraph<Integer> g = new WeightedGraph<>(order);
        for (int i = 0; i < order; i++) {
            if(!g.existsVertex(i)) {
                g.insertVertex(i);
            }
            if(alpha > 0) {
                int rdm = (int) (Math.random() * (order-1));
                if(alpha - rdm >= 0) {
                    alpha -= rdm;
                    for (int j = 0; j < rdm; j++) {
                        int number = (int) (Math.random() * order);
                        if(number != i) {
                            int cost = (int) (Math.random() * 200);
                            if (!g.existsEdge(i, number)) {
                                g.insertEdge(i,number, cost);
                            } else --j;
                        } else ++alpha;
                    }
                }
            }
            if(i == order-1 && alpha != 0) {
                i = -1;
            }
        }
        return g;
    }

    static void printGraph(WeightedGraph<Integer> g) {
        List<Integer> V = g.getV();
        System.out.println(V.toString());
        List<List<WeightedEdge>> A = g.getA();
        for (int i = 0; i < A.size(); i++) {
            if(!A.get(i).isEmpty()) {
                String s = i + ": [";
                s += A.get(i).get(0).toString();
                for (int j = 1; j < A.get(i).size(); j++) {
                    s += ", " + A.get(i).get(j).toString();
                }
                s += "]";
                System.out.println(s);
            } else System.out.println(i + ": []");
        }
    }

    List<Integer> prim(WeightedGraph<Integer> g, int vertex) {
        int n = g.order();
        List<Integer> costo = new ArrayList<>(n);
        List<Integer> father = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            costo.add(1000000);
            father.add(-1);
        }
        costo.set(vertex, 0);
        List<Integer> V = g.getV();
        List<Integer> U = new ArrayList<>();
        while(!V.isEmpty()) {
            int imin = 0;
            int min = costo.get(V.get(0));
            for (int i = 0; i < V.size(); i++) {
                if (costo.get(V.get(i)) < min) {
                    imin = i;
                    min = costo.get(V.get(i));
                }
            }
            int imin2 = V.get(imin);
            V.remove(imin);
            U = g.getAdjList(imin2);

            for (int u : U) {
                if (V.contains(u) && g.getCost(u, imin2) < costo.get(u)) {
                    father.set(u, imin2);
                    costo.set(u, g.getCost(u, imin2));
                }
            }
        }
        return father;
    }

    void flatSearch(WeightedGraph<Integer> g) {
        List<Integer> V = g.getV();
        for (int i = 0; i < g.order(); i++) {
            System.out.println(V.get(i));
        }
    }

    void DFS(WeightedGraph<Integer> g, int vertex) {
        Stack<Integer> stack = new Stack<Integer>(g.order());
        List<Integer> visited = new ArrayList<>();
        List<Integer> V = g.getV();
        int t;
        stack.push(vertex);
        visited.add(vertex);
        while (!stack.isEmpty()) {
            t = stack.peek();
            stack.pop();
            System.out.println(t);
            List<Integer> adj = g.getAdjList(t);
            for (Integer k : adj) {
                if (!visited.contains(k)) {
                    stack.push(k);
                    visited.add(k);
                }
            }

            if (visited.size() < V.size() && stack.isEmpty()) {
                for (Integer i : V) {
                    if (!visited.contains(i)) {
                        stack.push(i);
                        visited.add(i);
                        break;
                    }
                }
            }
        }
    }

    void BFS(WeightedGraph<Integer> g, int vertex) {
        DynamicQueue<Integer> queue = new DynamicQueue<Integer>();
        List<Integer> visited = new ArrayList<>();
        List<Integer> V = g.getV();
        int fr;
        queue.enqueue(vertex);
        visited.add(vertex);
        while (!queue.isEmpty()) {
            fr = queue.peek();
            queue.dequeue();
            System.out.println(fr);
            List<Integer> adj = g.getAdjList(fr);
            for (Integer k : adj) {
                if (!visited.contains(k)) {
                    visited.add(k);
                    queue.enqueue(k);
                }
            }

            if (visited.size() < V.size() && queue.isEmpty()) {
                for (Integer i : V) {
                    if (!visited.contains(i)) {
                        queue.enqueue(i);
                        visited.add(i);
                        break;
                    }
                }
            }
        }
    }
}
