package games.goose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovePlayerTest {

    @Test
    public void moveFromStart() {

        String playerOne = "Pippo";
        String playerTwo = "Pluto";

        Game g = new Game();
        assertTrue(g.addPlayer(playerOne));
        assertTrue(g.addPlayer(playerTwo));

        assertEquals(0, g.playerPosition(playerOne));
        assertEquals(0, g.playerPosition(playerTwo));

        g.move(playerOne, 4, 2);
        assertEquals(6, g.playerPosition(playerOne));

        g.move(playerTwo, 2, 2);
        assertEquals(4, g.playerPosition(playerTwo));
    }

    @Test
    public void moveFromPosition() {
        String playerOne = "Pippo";

        Game g = new Game();
        assertTrue(g.addPlayer(playerOne));
        g.move(playerOne, 4, 2);
        assertEquals(6, g.playerPosition(playerOne));
        g.move(playerOne, 2, 3);
        assertEquals(11, g.playerPosition(playerOne));
    }

}
