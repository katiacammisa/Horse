package MateDis;

import java.util.ArrayList;
import java.util.List;

class GraphApp<T> {

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

    void printGraph(WeightedGraph<Integer> g) {
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
            }
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
