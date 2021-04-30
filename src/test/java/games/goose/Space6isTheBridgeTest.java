package games.goose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Space6isTheBridgeTest {

    @Test
    public void space6isTheBridge() {
        MoveRules rules = new GooseMoveRules();
        MovesHistory result = rules.nextPosition(4, 1, 1);
        assertEquals(12, result.lastMove().position);
    }
}
