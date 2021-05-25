package games.dice.utils;

public class HumanDice implements Dice {

    private final int value;

    public HumanDice(int value) {
        this.value = value;
    }

    @Override
    public int throwDice() {
        return value;
    }
}
