package games;

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