package games.dice.goose;

import games.dice.goose.GooseGame;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddPlayerTest {

    @Test
    public void addFirstPlayer()
    {
        GooseGame g = new GooseGame();
        assertTrue(g.addPlayer("Pippo"));
        assertEquals(1, g.getPlayersCount());
        assertTrue(g.existPlayer("Pippo"));
    }

    @Test
    public void addSecondPlayer()
    {
        GooseGame g = new GooseGame();
        assertTrue(g.addPlayer("Pippo"));
        assertTrue(g.addPlayer("Pluto"));
        assertEquals(2, g.getPlayersCount());
        assertTrue(g.existPlayer("Pluto"));
    }

    @Test
    public void addExistingPlayer()
    {
        GooseGame g = new GooseGame();
        assertTrue(g.addPlayer("Pippo"));
        assertFalse(g.addPlayer("Pippo"));
        assertEquals(1, g.getPlayersCount());
    }

}
