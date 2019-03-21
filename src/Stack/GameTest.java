package Stack;

import org.junit.Test;

public class GameTest {

    Horse horse = new Horse();
    Game game = new Game(horse);

    @Test
    public void horsePossibleJumps() {
        game.horsePossibleJumps();
    }

}
