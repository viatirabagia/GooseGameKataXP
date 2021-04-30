package games.goose;

public class MockGame implements Game {

    private String lastMovedPlayer;
    private String lastAddedPlayer;
    private int[] lastMove;

    @Override
    public boolean addPlayer(String player) {
        this.lastAddedPlayer = player;
        return true;
    }

    @Override
    public MoveRules.MoveResult move(String player) {
        this.lastMovedPlayer = player;
        this.lastMove = null;
        return null;
    }

    @Override
    public MoveRules.MoveResult move(String player, int diceOne, int diceTwo) {
        this.lastMovedPlayer = player;
        this.lastMove = new int[] {diceOne, diceTwo};
        return null;
    }

    public boolean isLastMovedPlayer(String player) {
        return player.equals(this.lastMovedPlayer);
    }

    public int[] lastMove() {
        return lastMove;
    }

    public boolean isLastAddedPlayer(String player) {
        return player.equals(this.lastAddedPlayer);
    }
}
