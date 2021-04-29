package games.goose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameThrowsDiceTest {

    @Test
    public void gameMovesPlayer() {

        String playerOne = "Pippo";

        Game g = new Game();
        assertTrue(g.addPlayer(playerOne));

        g.forcePosition(playerOne, 4);
        assertEquals(4, g.playerPosition(playerOne));

        g.move(playerOne);
        assertEquals(7, g.playerPosition(playerOne));

    }

}
