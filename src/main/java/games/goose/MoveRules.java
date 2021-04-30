package games.goose;

public interface MoveRules {

    public enum MoveResult {
        WIN,
        REBOUND,
        GOOSE,
        BRIDGE,
        DEFAULT
    }
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
