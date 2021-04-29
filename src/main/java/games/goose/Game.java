package games.goose;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    public enum MoveResult {
        WIN,
        REBOUND,
        DEFAULT
    }

    private List<String> players = new ArrayList<>();
    private Map<String, Integer> positions = new HashMap<>();

    /**
     *
     * @param player
     * @return true if added, false otherwise
     */
    public boolean addPlayer(final String player) {
        if (player == null || players.contains(player)) {
            return false;
        }
        players.add(player);
        return true;
    }

    public int getPlayersCount() {
        return players.size();
    }

    public boolean existPlayer(final String player) {
        return player==null ? false : players.contains(player);
    }

    public MoveResult move(final String player, int diceOne, int diceTwo) {
        int currentPosition = playerPosition(player);
        int nextPosition = nextPosition(currentPosition, diceOne, diceTwo);
        MoveResult result = MoveResult.DEFAULT;
        if (nextPosition == 63) {
            result = MoveResult.WIN;
        } else if (nextPosition > 63) {
            nextPosition = 63 - (nextPosition - 63);
            result = MoveResult.REBOUND;
        }
        positions.put(player, nextPosition);
        return result;
    }

    private int nextPosition(int currentPosition, int diceOne, int diceTwo) {
        return currentPosition + diceOne + diceTwo;
    }

    public int playerPosition(final String player) {
        Integer currentPosition = positions.get(player);
        if (currentPosition == null) {
            return 0;
        }
        return currentPosition;
    }

    public void forcePosition(final String player, int newPosition) {
        positions.put(player, newPosition);
    }
}
