package Stack;

import org.junit.Test;

public class GameTest {

    Horse horse = new Horse();
    Game game = new Game();

    @Test
    public void horsePossibleJumps() {
        game.horsePossibleJumps(horse);
    }

}
