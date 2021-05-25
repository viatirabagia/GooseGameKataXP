package games;

import games.dice.MoveRules;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MovesHistory implements Iterable<Result> {

    List<Result> moves = new ArrayList<>();

    public void add(Result move) {
        moves.add(move);
    }

    public Result lastMove() {
        if (moves.isEmpty()) {
            return null;
        }
        return moves.get(moves.size()-1);
    }

    public void add(MovesHistory otherHistory) {
        if (otherHistory == null || otherHistory.isEmpty()) {
            return;
        }
        for (Iterator<Result> it = otherHistory.iterator(); it.hasNext(); ) {
            Result move = it.next();
            this.add(move);
        }
    }

    public boolean isEmpty() {
        return moves.isEmpty();
    }

    @Override
    public Iterator<Result> iterator() {
        return moves.iterator();
    }

    @Override
    public void forEach(Consumer<? super Result> action) {
        moves.forEach(action);
    }

    @Override
    public Spliterator<Result> spliterator() {
        return moves.spliterator();
    }

}
