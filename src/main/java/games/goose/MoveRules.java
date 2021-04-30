package games.goose;

public interface MoveRules {

    public enum MoveResult {
        WIN,
        REBOUND,
        DEFAULT
    }
    public class Result {
        public final MoveResult type;
        public final int position;

        public Result(MoveResult type, int position) {
            this.type = type;
            this.position = position;
        }
    }
    public Result nextPosition(int currentPosition, int dice1, int dice2);
}
