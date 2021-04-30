package games.goose;

import games.utils.AutomaticDice;

public interface Game {

    public boolean addPlayer(final String player);
    public MoveRules.MoveResult move(final String player);
    public MoveRules.MoveResult move(final String player, int diceOne, int diceTwo);

}
