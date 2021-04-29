package games.goose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WinTest {

    @Test
    public void playerMoveToWinPosition() {

        MoveRules rules = new GooseMoveRules();
        MoveRules.Result result = rules.nextPosition(60, 1, 2);
        assertEquals(63, result.position);
        assertEquals(MoveRules.MoveResult.WIN, result.type);

    }

    @Test
    public void playerMoveBeyondWinPositionAndRebound() {

        MoveRules rules = new GooseMoveRules();
        MoveRules.Result result = rules.nextPosition(60, 3, 2);
        assertEquals(61, result.position);
        assertEquals(MoveRules.MoveResult.REBOUND, result.type);

    }

}
