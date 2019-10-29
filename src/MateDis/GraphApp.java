package MateDis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class GraphApp<T> {

    public static void main(String[] args) {
        WeightedGraph<Integer> g = new WeightedGraph<>();
        Scanner scanner = new Scanner(System.in);
        int n;
        while (true){
            System.out.println("Enter 1 to insert vertex. \n" +
                                "Enter 2 to insert edge. \n" +
                                "Enter 3 to delete vertex. \n" +
                                "Enter 4 to delete edge. \n" +
                                "Enter 5 to get cost of edge. \n" +
                                "Enter 6 to get adjacent list. \n" +
                                "Enter 7 to print graph. \n" +
                                "Enter 8 to exit.");

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
                        g.getCost(c1, c2);
                    } else {
                        System.out.println("This edge doesn't exist.");
                    }
                case 6:
                    System.out.println("Insert the vertex to get adj list.");
                    int adj = scanner.nextInt();
                    if (g.existsVertex(adj)) {
                        System.out.println(g.getAdjList(adj).toString());
                    } else {
                        System.out.println("This vertex doesn't exist");
                    }
                case 7:
                    printGraph(g);
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }

    WeightedGraph<Integer> rdmGraph(int order, int alpha){
        if(alpha > ((order*(order-1))/2)){
            throw new IllegalArgumentException("alpha should be <= order*(order-1)/2");
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

    int[ ] Prim(WeightedGraph g, int s) {
        //WeightedGraph: Grafo no dirigido ponderado
        int n = g.order();
        int[] distance = new int[n];
        int[] padre = new int[n];

        for(int i =0; i < n ; i++){
            distance[i] = -1;
            padre[i] = -1;
        }
        distance[s] = 0;
        ArrayList<Integer> V = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            V.add(i);
        }
        List<Integer> lst;
        while(!V.isEmpty()){
            //buscar u en V tal que la distancia[u] sea mínima;
            int u = 0;
            for (Integer integer : V) {
                if (distance[integer] < distance[V.get(u)]) {
                    u = integer;
                }
            }
            //sacar u de V;
            V.remove(u);
            lst = g.getAdjList(u);
            for (int v : lst) {
                if ((V.contains(v)) && g.getCost(v, u) < distance[v]) {
                    padre[v] = u;
                    distance[v] = g.getCost(v, u);
                }
            }
        }
        return padre;
    }

}
