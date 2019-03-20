package Stack;

import java.util.ArrayList;
import java.util.List;

public class Horse {

    private List<Position> possibilities;

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
    }

    public List<Position> whereToJump(Position actualPosition){
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
}
