package Stack;

import java.util.ArrayList;
import java.util.List;

public class Horse {

    private List<Position> possibilities;
    private Position actualPosition;

    public Horse() {
        possibilities = new ArrayList<>();
        possibilities.add(new Position("1,2"));
        possibilities.add(new Position("1,-2"));
        possibilities.add(new Position("-1,2"));
        possibilities.add(new Position("-1,-2"));
        possibilities.add(new Position("2,1"));
        possibilities.add(new Position("2,-1"));
        possibilities.add(new Position("-2,1"));
        possibilities.add(new Position("-2,-1"));
        actualPosition = new Position(0, 0);
    }

    public List<Position> whereToJump(){
        List<Position> aux = new ArrayList<Position>();
        List<Position> result = new ArrayList<Position>();

        for (int i = 0; i < possibilities.size(); i++) {
            aux.add(new Position(possibilities.get(i).getX()+actualPosition.getX(),possibilities.get(i).getY()+actualPosition.getY()));
        }

        for (int i = 0; i < 8; i++) {
            if(aux.get(i).getX() >= 0 &&
                    aux.get(i).getY() >= 0 &&
                    aux.get(i).getX() < 8 &&
                    aux.get(i).getY() < 8) {
                result.add(aux.get(i));
            }
        }

        return result;
    }

    public Position getActualPosition() {
        return actualPosition;
    }

    public void setActualPosition(Position actualPosition) {
        this.actualPosition = actualPosition;
    }
}
