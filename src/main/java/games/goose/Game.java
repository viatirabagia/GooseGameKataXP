package games.goose;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<String> players = new ArrayList<>();

    /**
     *
     * @param player
     * @return true if added, false otherwise
     */
    public boolean addPlayer(String player) {
        if (player == null || players.contains(player)) {
            return false;
        }
        players.add(player);
        return true;
    }

    public int getPlayersCount() {
        return players.size();
    }

    public boolean existPlayer(String player) {
        return player==null ? false : players.contains(player);
    }

    public void move(String player, int diceOne, int diceTwo) {
    }

    public int playerPosition(String player) {
        return -1;
    }
}
