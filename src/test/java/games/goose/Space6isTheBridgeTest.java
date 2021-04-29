package games.goose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Space6isTheBridgeTest {

    @Test
    public void space6isTheBridge() {
        MoveRules rules = new GooseMoveRules();
        MoveRules.Result result = rules.nextPosition(4, 1, 1);
        assertEquals(12, result.position);
    }
}
