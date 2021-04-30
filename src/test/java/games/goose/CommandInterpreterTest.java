package games.goose;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommandInterpreterTest {

    @Test
    public void addPlayer()
    {
        MockGame game = new MockGame();
        CommandInterpreter i = new CommandInterpreter(game);
        i.command("add player Pippo");
        assertTrue(game.addedPlayer("Pippo"));
    }
    @Test
    public void movePlayer()
    {
        MockGame game = new MockGame();
        CommandInterpreter i = new CommandInterpreter(game);
        i.command("move Pippo 2, 3");
        assertTrue(game.isLastMovedPlayer("Pippo"));
        assertEquals(new int[] {2,3}, game.lastMove("Pippo"));
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
