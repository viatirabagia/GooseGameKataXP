package games.dice;

import games.MovesHistory;

public interface MoveRules {

    /**
     *
     * @param currentPosition
     * @param dice1
     * @param dice2
     * @return moves done
     */
    public MovesHistory nextPosition(int currentPosition, int dice1, int dice2);
}
