package Stack;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private boolean[][] board = new boolean[8][8];
    private DynamicStack<String>[] piles;
//    private Position currentPosition;

    public Game() {
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = false;
            }
        }
        board[0][0] = true;
        piles = new DynamicStack[4];
        for (int i = 0; i < 4; i++) {
            piles[i] = new DynamicStack<String>();
        }
    }

    private void fillOnePile(Horse horse){

        List<Position> possibilities = horse.whereToJump();


        for (int i = 0; i < piles.length; i++) {
            if (piles[i].isEmpty()) {
                for (int j = 0; j < possibilities.size(); j++) {
                    piles[i].push(possibilities.get(j).toString());
                }
                board[new Position(piles[i].peek()).getX()][new Position(piles[i].peek()).getY()] = true;
                board[horse.getActualPosition().getX()][horse.getActualPosition().getY()] = false;
                break;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]) {
                    horse.setActualPosition(new Position(i, j));
                }
            }
        }
    }

    public Position deserialize(String position){
        return new Position(Integer.parseInt(position.split(",")[0]), Integer.parseInt(position.split(",")[1]));
    }

    public void possibilitiesIn4Jumps(Horse horse) {
        List<Possibility> possibilityList = new ArrayList<Possibility>();

        while(piles[3].isEmpty()){
            fillOnePile(horse);
        }

        while(!piles[0].isEmpty()){
            horse.setActualPosition(deserialize(piles[0].peek()));
            board[horse.getActualPosition().getX()][horse.getActualPosition().getY()] = true;
            fillOnePile(horse);
            while (!piles[1].isEmpty()){
                horse.setActualPosition(deserialize(piles[1].peek()));
                board[horse.getActualPosition().getX()][horse.getActualPosition().getY()] = true;
                fillOnePile(horse);
                while (!piles[2].isEmpty()) {
                    horse.setActualPosition(deserialize(piles[2].peek()));
                    board[horse.getActualPosition().getX()][horse.getActualPosition().getY()] = true;
                    fillOnePile(horse);
                    while (!piles[3].isEmpty()) {
                        horse.setActualPosition(deserialize(piles[3].peek()));
                        board[horse.getActualPosition().getX()][horse.getActualPosition().getY()] = true;
                        possibilityList.add(new Possibility(new Position(piles[0].peek()),
                                new Position(piles[1].peek()),
                                new Position(piles[2].peek()),
                                new Position(piles[3].peek())));
                        piles[3].pop();
                    }
                    piles[2].pop();
                }
                piles[1].pop();
            }
            piles[0].pop();
        }

        System.out.println(possibilityList.toString());
    }
//
//    public void recursivePossibleJumps(Horse horse){
//        List<Possibility> possibilityList = new ArrayList<Possibility>();
//        while (piles[3].isEmpty()){
//            fillOnePile(horse);
//        }
//        int i = 3;
//        System.out.println(recursivePossibleJumps(horse, possibilityList, i).toString());
//    }
//
//    private List recursivePossibleJumps(Horse horse, List<Possibility> possibilityList, int i) {
//        if(i == -1){
//            return possibilityList;
//        }
//        while ((!piles[i].isEmpty())) {
//            horse.setActualPosition(deserialize(piles[i].peek()));
//            board[horse.getActualPosition().getX()][horse.getActualPosition().getY()] = true;
//            while (!piles[3].isEmpty()) {
//                horse.setActualPosition(deserialize(piles[3].peek()));
//                board[horse.getActualPosition().getX()][horse.getActualPosition().getY()] = true;
//                possibilityList.add(new Possibility(new Position(piles[0].peek()),
//                        new Position(piles[1].peek()),
//                        new Position(piles[2].peek()),
//                        new Position(piles[3].peek())));
//                piles[3].pop();
//            }
//            piles[i].pop();
//        }
//
//        return recursivePossibleJumps(horse, possibilityList, --i);
//    }

}
