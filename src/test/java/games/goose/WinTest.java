package games.goose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WinTest {

    @Test
    public void playerMoveToWinPosition() {

        String playerOne = "Pippo";

        Game g = new Game();
        assertTrue(g.addPlayer(playerOne));

        g.forcePosition(playerOne, 60);
        assertEquals(60, g.playerPosition(playerOne));

        assertEquals(Game.MoveResult.WIN, g.move(playerOne, 1, 2));

    }

    @Test
    public void playerMoveBeyondWinPositionAndRebound() {

        String playerOne = "Pippo";

        Game g = new Game();
        assertTrue(g.addPlayer(playerOne));

        g.forcePosition(playerOne, 60);
        assertEquals(60, g.playerPosition(playerOne));

        assertEquals(Game.MoveResult.REBOUND, g.move(playerOne, 3, 2));

        assertEquals(61, g.playerPosition(playerOne));

    }

}
