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
        List<Position> result = possibilities;

        for (int i = 0; i <possibilities.size(); i++) {
            result.get(i).setX(possibilities.get(i).getX()+actualPosition.getX());
            result.get(i).setY(possibilities.get(i).getY()+actualPosition.getY());
        }
        for (int i = 0; i < possibilities.size(); i++) {
            if(result.get(i).getX() < 0 || result.get(i).getY() < 0){
                result.remove(i);
            }
        }

        return result;
    }




}
