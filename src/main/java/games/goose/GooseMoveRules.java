package games.goose;

import java.util.Arrays;
import java.util.List;

public class GooseMoveRules implements MoveRules {

    private final static List<Integer> goosePositions = Arrays.asList(5,14,23,9,18,27);

    @Override
    public Result nextPosition(int currentPosition, int dice1, int dice2) {
        int nextPosition = calculateNextPosition(currentPosition, dice1, dice2);
        MoveResult type = MoveResult.DEFAULT;
        if (nextPosition == 63) {
            type = MoveResult.WIN;
        } else if (nextPosition > 63) {
            nextPosition = 63 - (nextPosition - 63);
            type = MoveResult.REBOUND;
        } else if (nextPosition == 6) {
            nextPosition = 12;
        } else if (goosePositions.contains(nextPosition)) {
            return nextPosition(nextPosition, dice1, dice2);
        }
        return  new Result(type, nextPosition);
    }

    private int calculateNextPosition(int currentPosition, int diceOne, int diceTwo) {
        return currentPosition + diceOne + diceTwo;
    }

}
