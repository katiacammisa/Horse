package Stack;

import org.junit.Test;

public class GameTest {

    Horse horse = new Horse();
    Game game = new Game();

    @Test
    public void possibilitiesIn4Jumps() {
        game.possibilitiesIn4Jumps(horse);
    }

}
