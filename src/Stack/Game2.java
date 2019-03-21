package Stack;

import java.util.ArrayList;
import java.util.List;

public class Game2 {
    private boolean[][] board = new boolean[8][8];
    private Horse horse;
    private Stack<String>[] piles;
    private Position currentPosition;

    public Game2(Horse horse) {
        this.horse = horse;
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = false;
            }
        }
        board[0][0] = true;
        piles = new Stack[4];
        for (int i = 0; i < 4; i++) {
            piles[i] = new Stack<String>(8);
        }
        currentPosition = new Position(0,0);
    }

    private void fillOnePile(){

        List<Position> possibilities = horse.whereToJump(currentPosition);


        for (int i = 0; i < piles.length; i++) {
            if (piles[i].isEmpty()) {
                for (int j = 0; j < possibilities.size(); j++) {
                    piles[i].push(possibilities.get(j).toString());
                }
                board[new Position(piles[i].peek()).getX()][new Position(piles[i].peek()).getY()] = true;
                board[currentPosition.getX()][currentPosition.getY()] = false;
                break;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]) {
                    currentPosition = new Position(i, j);
                }
            }
        }
    }

    public Position deserialize(String position){
        return new Position(Integer.parseInt(position.split(",")[0]), Integer.parseInt(position.split(",")[1]));
    }

    public void horsePossibleJumps() {
        List<Possibility> possibilityList = new ArrayList<Possibility>();

        while(piles[3].isEmpty()){
            fillOnePile();
        }

        while(!piles[0].isEmpty()){
            currentPosition = deserialize(piles[0].peek());
            board[currentPosition.getX()][currentPosition.getY()] = true;
            fillOnePile();
            while (!piles[1].isEmpty()){
                currentPosition = deserialize(piles[1].peek());
                board[currentPosition.getX()][currentPosition.getY()] = true;
                fillOnePile();
                while (!piles[2].isEmpty()) {
                    currentPosition = deserialize(piles[2].peek());
                    board[currentPosition.getX()][currentPosition.getY()] = true;
                    fillOnePile();
                    while (!piles[3].isEmpty()) {
                        currentPosition = deserialize(piles[3].peek());
                        board[currentPosition.getX()][currentPosition.getY()] = true;
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

}
