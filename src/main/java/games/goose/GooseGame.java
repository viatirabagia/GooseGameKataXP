package games.goose;

import games.utils.AutomaticDice;
import games.utils.Dice;
import games.utils.HumanDice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GooseGame implements Game {

    public static interface Listener {
        public void notifyAddPlayer(final String player, boolean added);
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
            listener.notifyAddPlayer(player, success);
        }
        return success;
    }

    public int getPlayersCount() {
        return players.size();
    }

    public boolean existPlayer(final String player) {
        return player==null ? false : players.contains(player);
    }

    public MoveRules.MoveResult move(final String player) {
        return move(player, new AutomaticDice(), new AutomaticDice());
    }
    public MoveRules.MoveResult move(final String player, int diceOne, int diceTwo) {
        return move(player, new HumanDice(diceOne), new HumanDice(diceTwo));
    }

    private MoveRules.MoveResult move(final String player, Dice diceOne, Dice diceTwo) {
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
            //MoveRules.Result[] moves = result.toArray(new MoveRules.Result[] {});
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
