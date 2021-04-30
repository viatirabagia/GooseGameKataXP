package games.goose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovePlayerTest {

    @Test
    public void moveFromStart() {

        String playerOne = "Pippo";
        String playerTwo = "Pluto";

        GooseGame g = new GooseGame();
        assertTrue(g.addPlayer(playerOne));
        assertTrue(g.addPlayer(playerTwo));

        assertEquals(0, g.playerPosition(playerOne));
        assertEquals(0, g.playerPosition(playerTwo));

        g.move(playerOne, 4, 3);
        assertEquals(7, g.playerPosition(playerOne));

        g.move(playerTwo, 2, 2);
        assertEquals(4, g.playerPosition(playerTwo));
    }

    @Test
    public void moveFromPosition() {
        String playerOne = "Pippo";

        GooseGame g = new GooseGame();
        assertTrue(g.addPlayer(playerOne));
        g.move(playerOne, 4, 3);
        assertEquals(7, g.playerPosition(playerOne));
        g.move(playerOne, 2, 3);
        assertEquals(12, g.playerPosition(playerOne));
    }

}
