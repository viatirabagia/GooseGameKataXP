package games.goose;

public interface MoveRules {

    public enum MoveResult {
        WIN,
        REBOUND,
        DEFAULT
    }
    public class Result {
        public MoveResult type;
        public int position;
    }
    public Result nextPosition(int currentPosition, int dice1, int dice2);
}
