package games.goose;

public interface MoveRules {

    public interface MoveResult {};

    public class Result {
        public final MoveResult type;
        public final int previousPosition;
        public final int position;

        public Result(final MoveResult type, int position, int previousPosition) {
            this.type = type;
            this.position = position;
            this.previousPosition = previousPosition;
        }
    }

    /**
     *
     * @param currentPosition
     * @param dice1
     * @param dice2
     * @return moves done
     */
    public MovesHistory nextPosition(int currentPosition, int dice1, int dice2);
}
