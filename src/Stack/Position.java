package Stack;

public class Position {

    private int x;
    private int y;

    public Position(String position) {
        x = Integer.parseInt(position.split(",")[0]);
        y = Integer.parseInt(position.split(",")[1]);
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString(){
        return x + "," + y;
    }
}
