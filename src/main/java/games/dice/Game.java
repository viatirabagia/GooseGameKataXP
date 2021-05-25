package games.dice;

import games.MoveResult;

public interface Game {

    public boolean addPlayer(final String player);
    public MoveResult move(final String player);
    public MoveResult move(final String player, int diceOne, int diceTwo);

}
