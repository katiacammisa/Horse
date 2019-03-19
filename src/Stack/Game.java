package Stack;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private boolean[][] board = new boolean[8][8];
    private Horse horse;
    private Stack<String>[] piles;

    public Game(Horse horse) {
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
    }


    public void horsePossibleJumps() {
        //posibilidades por lugar
        //imprimir
        List<Possibility> possibilityList = new ArrayList<Possibility>();

        int totalPossibilities = 0;
        while(totalPossibilities < 398) {

            Position currentPosition = new Position(0, 0);

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j]) {
                        currentPosition = new Position(i, j);
                    }
                }
            }

            while(piles[3].isEmpty()){
                fillOnePile(currentPosition);
            }

            possibilityList.add(new Possibility(new Position(piles[0].peek()),
                                                new Position(piles[1].peek()),
                                                new Position(piles[2].peek()),
                                                new Position(piles[3].peek())));

            board[currentPosition.getX()][currentPosition.getY()] = false;

            ++totalPossibilities;
        }
    }

    private void fillOnePile(Position currentPosition){

        List<Position> possibilities = horse.whereToJump(currentPosition);

        for (int i = 0; i < piles.length; i++) {
            if (piles[i].isEmpty()) {
                for (int j = 0; j < possibilities.size(); j++) {
                    piles[i].push(possibilities.get(j).toString());
                }
                board[new Position(piles[i].peek()).getX()][new Position(piles[i].peek()).getY()] = true;
                piles[i].pop();
                break;
            }
        }

    }
}
