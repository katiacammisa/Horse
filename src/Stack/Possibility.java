package Stack;

public class Possibility {

    private Position p1;
    private Position p2;
    private Position p3;
    private Position p4;

    public Possibility(Position p1, Position p2, Position p3, Position p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public String toString(){
        return "<" + p1.toString() + ", " + p2.toString() + ", " + p3.toString() + ", " + p4.toString() + ">";
    }
}
