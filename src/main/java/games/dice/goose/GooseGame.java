package games.dice.goose;

import games.MoveResult;
import games.dice.MoveRules;
import games.MovesHistory;
import games.dice.Game;
import games.dice.utils.AutomaticDice;
import games.dice.utils.Dice;
import games.dice.utils.HumanDice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GooseGame implements Game {

    public static interface Listener {
        public void notifyAddPlayer(final String player, boolean added,  final List<String> players);
        public void notifyMovePlayer(final String player, int diceOne, int diceTwo,
                                     final MovesHistory moves);
    }

    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    private List<String> players = new ArrayList<>();
    private Map<String, Integer> positions = new HashMap<>();
    private MoveRules rules = new GooseMoveRules();

    /**
     *
     * @param player
     * @return true if added, false otherwise
     */
    public boolean addPlayer(final String player) {
        boolean success = false;
        if (!existPlayer(player)) {
            players.add(player);
            success = true;
        }
        if (listener != null) {
            listener.notifyAddPlayer(player, success, players);
        }
        return success;
    }

    public int getPlayersCount() {
        return players.size();
    }

    public boolean existPlayer(final String player) {
        return player==null ? false : players.contains(player);
    }

    public MoveResult move(final String player) {
        return move(player, new AutomaticDice(), new AutomaticDice());
    }
    public MoveResult move(final String player, int diceOne, int diceTwo) {
        return move(player, new HumanDice(diceOne), new HumanDice(diceTwo));
    }

    private MoveResult move(final String player, Dice diceOne, Dice diceTwo) {
        if (!existPlayer(player)) {
            return null;
        }
        //
        int currentPosition = playerPosition(player);
        int diceThrownOne = diceOne.throwDice();
        int diceThrownTwo = diceTwo.throwDice();
        MovesHistory result = rules.nextPosition(currentPosition, diceThrownOne, diceThrownTwo);
        positions.put(player, result.lastMove().position);
        //
        if (listener != null) {
            //Result[] moves = result.toArray(new Result[] {});
            listener.notifyMovePlayer(player, diceThrownOne, diceThrownTwo, result);
        }
        //
        return result.lastMove().type;
    }

    public int playerPosition(final String player) {
        Integer currentPosition = positions.get(player);
        if (currentPosition == null) {
            return 0;
        }
        return currentPosition;
    }

    public String[] getPlayersList() {
        return players.toArray(new String[] {});
    }

}
