package games.goose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GooseMoveRules implements MoveRules {

    private final static List<Integer> goosePositions = Arrays.asList(5,14,23,9,18,27);

    @Override
    public MovesHistory nextPosition(int currentPosition, int dice1, int dice2) {
        MovesHistory moves = new MovesHistory();
        //
        int nextPosition = calculateNextPosition(currentPosition, dice1, dice2);
        MoveResult type = MoveResult.DEFAULT;
        if (nextPosition == 63) {
            type = MoveResult.WIN;
        } else if (nextPosition > 63) {
            moves.add(new Result(MoveResult.REBOUND, nextPosition, currentPosition));
            //nextPosition = 63 - (nextPosition - 63);
            int delta = 63 - nextPosition;
            moves.add(nextPosition(63, delta, 0));
            return moves;
        } else if (nextPosition == 6) {
            //The Bridge 6->12
            moves.add(new Result(MoveResult.BRIDGE, nextPosition, currentPosition));
            moves.add(nextPosition(nextPosition, 3, 3));
            return moves;
        } else if (goosePositions.contains(nextPosition)) {
            moves.add(new Result(MoveResult.GOOSE, nextPosition, currentPosition));
            moves.add(nextPosition(nextPosition, dice1, dice2));
            return moves;
        }
        moves.add(new Result(type, nextPosition, currentPosition));
        return moves;
    }

    private int calculateNextPosition(int currentPosition, int diceOne, int diceTwo) {
        return currentPosition + diceOne + diceTwo;
    }

}
