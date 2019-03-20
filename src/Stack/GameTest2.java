package Stack;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.*;

public class GameTest2 extends Assert {

    Horse horse = new Horse();
    Game2 game = new Game2(horse);

    @Test
    public void horsePossibleJumps() {
        game.horsePossibleJumps();
    }

}
