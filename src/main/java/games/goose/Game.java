package games.goose;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

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

    public void move(String player, int diceOne, int diceTwo) {
        int currentPosition = playerPosition(player);
        positions.put(player, nextPosition(currentPosition, diceOne, diceTwo));

    }

    private Integer nextPosition(int currentPosition, int diceOne, int diceTwo) {
        return currentPosition + diceOne + diceTwo;
    }

    public int playerPosition(final String player) {
        Integer currentPosition = positions.get(player);
        if (currentPosition == null) {
            return 0;
        }
        return currentPosition;
    }

}
