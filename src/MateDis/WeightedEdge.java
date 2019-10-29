package MateDis;

public class WeightedEdge {

    private int cost;
    private int nextVertex;

    public WeightedEdge(int cost, int nextVertex) {
        this.cost = cost;
        this.nextVertex = nextVertex;
    }

    public int getCost() {
        return cost;
    }

    public int getNextVertex() {
        return nextVertex;
    }
}
