package games;

import games.goose.CommandInterpreter;
import games.goose.GooseGame;
import games.goose.MoveRules;
import games.goose.MovesHistory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import static games.goose.MoveRules.MoveResult;

public class Main {

    public static void main(String[] args) throws Exception {
        listen();
    }

    private static void listen() throws Exception {
        GooseGame game = new GooseGame();
        game.setListener(new GameListener(game));
        CommandInterpreter cmdInterpreter = new CommandInterpreter(game);
        try {
            System.out.println(">enter bye to terminate");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            while (str != null) {
                System.out.print(">");
                str = in.readLine();
                if ("bye".equalsIgnoreCase(str)) {
                    System.out.println("bye!");
                    System.exit(0);
                }
                //
                if (!cmdInterpreter.command(str)) {
                    System.out.println("Invalid command");
                }
            }
        } catch (Exception e) {
        }
    }

    private static class GameListener implements GooseGame.Listener {
        private final GooseGame game;

        private GameListener(GooseGame game) {
            this.game = game;
        }

        @Override
        public void notifyAddPlayer(String player, boolean added) {
            System.out.println(added ? "add player " + player : player + ": already existing player");
            //list existing players
            String[] players = game.getPlayersList();
            System.out.print("players:");
            Arrays.stream(players).forEach(p -> System.out.print(p + ","));
            System.out.println();
        }

        @Override
        public void notifyMovePlayer(final String player,
                                     int diceOne, int diceTwo,
                                     final MovesHistory moves) {
            if (moves == null || moves.isEmpty()) {
                return;
            }
            //boolean previousIsGoose = false;
            //boolean previousIsTheBridge = false;
            //boolean previousIsGoose = false;
            MoveResult previousType = null;
            for (MoveRules.Result m : moves) {
                if (MoveResult.GOOSE.equals(previousType)) {
                    System.out.print(player + " moves again and goes to " + m.position + ". ");
                } else if (MoveRules.MoveResult.BRIDGE.equals(previousType)) {
                    System.out.print(player + " jumps to " + m.position + ". ");
                } else if (MoveResult.REBOUND.equals(previousType)) {
                    System.out.print(player + " returns to " + m.position + ". ");
                } else {
                    System.out.print(player + " rolls " + diceOne + "," + diceTwo + ". ");
                    System.out.print(player + " moves from " + (m.previousPosition == 0 ? "Start" : m.previousPosition)
                            + " to " + (MoveResult.BRIDGE.equals(m.type) ? " The Bridge " : m.position) + ". ");
                }
                //
                //previousIsGoose = false;
                if (MoveResult.WIN.equals(m.type)) {
                    System.out.print(player + " Wins!! ");
                } else if (MoveResult.REBOUND.equals(m.type)) {
                    System.out.print(player + " bounces! ");
                } else if (MoveResult.GOOSE.equals(m.type)) {
                    System.out.print(" The goose! ");
                    //previousIsGoose = true;
                } else if (MoveResult.BRIDGE.equals(m.type)) {
                    //previousIsTheBridge = true;
                }
                previousType = m.type;
            }
            System.out.println();
        }
    }

}
