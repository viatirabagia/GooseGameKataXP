package games.dice.goose;

import app.CommandInterpreter;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandInterpreterTest {

    @Test
    public void addPlayer()
    {
        MockGame game = new MockGame();
        CommandInterpreter i = new CommandInterpreter(game);
        i.command("add player Pippo");
        assertTrue(game.isLastAddedPlayer("Pippo"));
        i.command("add player Pluto");
        assertFalse(game.isLastAddedPlayer("Pippo"));
        assertTrue(game.isLastAddedPlayer("Pluto"));
    }
    @Test
    public void movePlayer()
    {
        MockGame game = new MockGame();
        CommandInterpreter i = new CommandInterpreter(game);
        i.command("move Pippo 2, 3");
        assertTrue(game.isLastMovedPlayer("Pippo"));
        assertEquals(2, game.lastMove()[0]);
        assertEquals(3, game.lastMove()[1]);
    }

    @Test
    public void movePlayerGameThrowsTheDice()
    {
        MockGame game = new MockGame();
        CommandInterpreter i = new CommandInterpreter(game);
        i.command("move Pippo");
        assertTrue(game.isLastMovedPlayer("Pippo"));
    }


}
