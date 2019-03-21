package Stack;

import org.junit.Assert;
import org.junit.Test;

public class GameTest extends Assert {

    Horse horse = new Horse();
    Game game = new Game(horse);

    @Test
    public void horsePossibleJumps() {
        game.horsePossibleJumps();
    }

}
