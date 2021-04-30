package games.goose;


import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class IfYouLandOnTheGooseMoveAgainTest {

    @Test
    public void ifYouLandOnTheGooseMoveAgain() {
        MoveRules rules = new GooseMoveRules();
        MovesHistory result = rules.nextPosition(3, 1, 1);
        assertEquals(7, result.lastMove().position);
        //5,14,23,9,18,27
    }

    @Test
    public void ifYouLandOnTheGooseManyTimesMoveAgain() {
        MoveRules rules = new GooseMoveRules();
        MovesHistory result = rules.nextPosition(10, 2, 2);
        assertEquals(22, result.lastMove().position);
    }

}
