package games;

import games.goose.CommandInterpreter;
import games.goose.Game;
import games.goose.GooseGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        listen();
    }

    private static void listen() throws Exception {
        CommandInterpreter cmdInterpreter = new CommandInterpreter(new GooseGame());
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            while (str != null) {
                System.out.print(">");
                str = in.readLine();
                //
                cmdInterpreter.command(str);
            }
        } catch (Exception e) {
        }
    }

}
