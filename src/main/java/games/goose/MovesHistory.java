package games.goose;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MovesHistory implements Iterable<MoveRules.Result> {

    List<MoveRules.Result> moves = new ArrayList<>();

    public void add(MoveRules.Result move) {
        moves.add(move);
    }

    public MoveRules.Result lastMove() {
        if (moves.isEmpty()) {
            return null;
        }
        return moves.get(moves.size()-1);
    }

    public void add(MovesHistory otherHistory) {
        if (otherHistory == null || otherHistory.isEmpty()) {
            return;
        }
        for (Iterator<MoveRules.Result> it = otherHistory.iterator(); it.hasNext(); ) {
            MoveRules.Result move = it.next();
            this.add(move);
        }
    }

    public boolean isEmpty() {
        return moves.isEmpty();
    }

    @Override
    public Iterator<MoveRules.Result> iterator() {
        return moves.iterator();
    }

    @Override
    public void forEach(Consumer<? super MoveRules.Result> action) {
        moves.forEach(action);
    }

    @Override
    public Spliterator<MoveRules.Result> spliterator() {
        return moves.spliterator();
    }

}
