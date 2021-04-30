package games.goose;

public class MockGame implements Game {

    @Override
    public boolean addPlayer(String player) {
        return false;
    }

    @Override
    public MoveRules.MoveResult move(String player) {
        return null;
    }

    @Override
    public MoveRules.MoveResult move(String player, int diceOne, int diceTwo) {
        return null;
    }

    public boolean isLastMovedPlayer(String player) {
        return false;
    }

    public int[] lastMove(String pippo) {
        return new int[] {};
    }

    public boolean addedPlayer(String pippo) {
        return false;
    }
}
