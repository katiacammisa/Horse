package MateDis;

import java.util.ArrayList;
import java.util.List;

public class GraphApp<T> {

    public WeightedGraph<Integer> rdmGraph(int order, int alpha){
        ArrayList<Integer> V = new ArrayList<>();
        List<List<WeightedEdge>> A = new ArrayList<List<WeightedEdge>>(order);
        for (int i = 0; i < order; i++)
            A.set(i, new ArrayList<>());
        for (int i = 0; i < order; i++) {
            V.add(i);
            if(alpha > 0) {
                int rdm = (int) (Math.random() * alpha);
                if(alpha - rdm >= 0) {
                    alpha -= rdm;
                    for (int j = 0; j < rdm; j++) {
                        List<Integer> oldNumbers = new ArrayList<>(rdm);
                        int number = (int) (Math.random() * order);
                        int cost = (int) (Math.random() * 200);
                        if (!oldNumbers.contains(number)) {
                            A.get(i).add(new WeightedEdge(cost, number));
                            oldNumbers.add(number);
                        } else --j;
                    }
                }
            }

        }
        return new WeightedGraph<Integer>(V,A);
    }



    public int[ ] Prim(WeightedGraph g, int s) {
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
