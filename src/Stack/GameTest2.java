package Stack;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.*;

public class GameTest2 extends Assert {

    Horse horse = new Horse();
    Game game = new Game(horse);

    @Test
    public void horsePossibleJumps() {
        game.horsePossibleJumps();
    }

}
