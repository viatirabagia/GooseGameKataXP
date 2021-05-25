package app;

import games.dice.Game;

import java.util.StringTokenizer;

public class CommandInterpreter {

    private final Game game;

    public CommandInterpreter(Game game) {
        this.game = game;
    }

    /**
     *
     * @param command
     * @return true if command executed, false if invalid command
     */
    public boolean command(String command) {
        if (command == null || command.trim().isEmpty()) {
            return false;
        }
        String commandSanitized = sanitize(command);
        String[] tokens = commandSanitized.split(" ");
        if (tokens[0].equalsIgnoreCase("add")) {
            if (tokens.length > 2) {
                if (tokens[1].equalsIgnoreCase("player")) {
                    game.addPlayer(tokens[2]);
                    return true;
                }
            }
        } else if (tokens[0].equalsIgnoreCase("move")) {
            if (tokens.length > 1) {
                String player = tokens[1];
                if (tokens.length > 3) {
                    try {
                        int dice1 = Integer.valueOf(tokens[2]);
                        int dice2 = Integer.valueOf(tokens[3]);
                        game.move(player, dice1, dice2);
                        return true;
                    } catch (Exception ex){
                    }
                } else {
                    game.move(player);
                    return true;
                }
            }
        }
        return false;
    }

    private String sanitize(String command) {
        return command.trim().replaceAll("\\W+", " ");
    }

}
