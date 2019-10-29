package MateDis;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph<T> {

    private List<T> V;
    private List<List<WeightedEdge>> A;
    private int alpha;

    WeightedGraph() {
       this(10);
    }

    WeightedGraph(int capacity) {
        V = new ArrayList<>(capacity);
        A = new ArrayList<List<WeightedEdge>>(capacity);
        for (int i = 0; i < capacity; i++) {
            A.set(i,new ArrayList<>());
        }
        alpha = 0;
    }

    WeightedGraph(List<T> V, List<List<WeightedEdge>> A){
        this.V = V;
        this.A = A;
    }

    void insertVertex(T x){
        V.add(x);
    }

    void insertEdge(int v, int w, int cost){
        if (!existsEdge(v, w)){
            A.get(v).add(new WeightedEdge(cost, w));
            A.get(w).add(new WeightedEdge(cost, v));
            alpha++;
        }
    }

    void deleteEdge(int v, int w){
        if (existsEdge(v,w)) {
            A.get(v).remove(w);
            A.get(w).remove(v);
            alpha--;
        }
    }

    void deleteVertex(int v){

        for (int i = 0; i < V.size(); i++)
            if(existsEdge(v,i))
                deleteEdge(v, i);
        V.remove(v);
        A.remove(v);
    }

    int getCost(int v, int w){
        for (int i = 0; i < A.get(v).size(); i++) {
            if(A.get(v).get(i).getNextVertex() == w){
                return A.get(v).get(i).getCost();
            }
        }
        return -1;
    }

    boolean existsEdge(int v, int w){
        return A.get(v).contains(w);
    }

    int order(){
        return V.size();
    }

    int edgeAmount(){
        return alpha;
    }

    T getVertex(int v){
        return V.get(v);
    }

    List<Integer> getAdjList(int v){
        ArrayList<Integer> lst = new ArrayList<Integer>();

        for (int i = 0; i < A.get(v).size(); i++) {
            lst.add(A.get(v).get(i).getNextVertex());
        }
        return lst;
    }

    void printGraph(){
        System.out.println(V.toString());
        for (int i = 0; i < A.size(); i++) {
            System.out.println(i + ": " + A.get(i).toString());
        }
    }
}
