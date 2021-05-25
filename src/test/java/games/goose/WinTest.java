package games.goose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WinTest {

    @Test
    public void playerMoveToWinPosition() {

        MoveRules rules = new GooseMoveRules();
        MovesHistory result  = rules.nextPosition(60, 1, 2);
        assertEquals(63, result.lastMove().position);
        assertEquals(GooseMoveResult.WIN, result.lastMove().type);

    }

    @Test
    public void playerMoveBeyondWinPositionAndRebound() {

        MoveRules rules = new GooseMoveRules();
        MovesHistory result  = rules.nextPosition(60, 3, 2);
        assertEquals(61, result.lastMove().position);

    }

}
