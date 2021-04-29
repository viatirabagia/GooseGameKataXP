package games.goose;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AddPlayerTest {

    @Test
    public void addFirstPlayer()
    {
        Game g = new Game();
        g.addPlayer("Pippo");
        assertEquals(1, g.getPlayersCount());
        assertTrue(g.existPlayer("Pippo"));
    }

    @Test
    public void addSecondPlayer()
    {
        Game g = new Game();
        g.addPlayer("Pippo");
        g.addPlayer("Pluto");
        assertEquals(2, g.getPlayersCount());
        assertTrue(g.existPlayer("Pluto"));
    }

    @Test
    public void addExistingPlayer()
    {
        Game g = new Game();
        g.addPlayer("Pippo");
        g.addPlayer("Pippo");
        assertEquals(1, g.getPlayersCount());
    }

}
