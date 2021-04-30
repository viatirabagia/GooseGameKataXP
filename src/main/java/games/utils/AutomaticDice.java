package games.utils;

public class AutomaticDice implements Dice {
    @Override
    public int throwDice() {
        return (int) (Math.random()*6+1);
    }
}
