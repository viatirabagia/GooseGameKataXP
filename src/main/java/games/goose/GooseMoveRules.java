package games.goose;

public class GooseMoveRules implements MoveRules {

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
        }
        Result r = new Result();
        r.type = type;
        r.position = nextPosition;
        return r;
    }

    private int calculateNextPosition(int currentPosition, int diceOne, int diceTwo) {
        return currentPosition + diceOne + diceTwo;
    }

}
