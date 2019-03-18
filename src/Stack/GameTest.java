package Stack;

import org.junit.Test;

class GameTest {

    private Horse horse = new Horse();
    Game game = new Game(horse);

    @Test
    void horsePossibleJumps() {
        game.horsePossibleJumps();
    }
}