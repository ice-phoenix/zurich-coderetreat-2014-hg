package ch.coderetreat.engine;

import ch.coderetreat.field.Field;

import java.util.List;

import static ch.coderetreat.field.Field.State;

public class GameOfLifeEngine {

    private final int width;
    private final int height;

    private Field old_;
    private Field new_;

    public GameOfLifeEngine(final int width, final int height) {
        this.width = width;
        this.height = height;
        this.old_ = new Field(width, height);
        this.new_ = new Field(width, height);
    }

    // TODO Remove me later!
    public Field getOld_() {
        return old_;
    }

    // TODO Remove me later!
    public Field getNew_() {
        return new_;
    }

    public GameOfLifeEngine step() {
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                final State curr = old_.getCell(i, j);
                final List<State> neighs = old_.getNeighbours(i, j);
                final long nCount = neighs.stream()
                                          .filter(n -> n == State.LIVE)
                                          .count();

                final State next;

                if (State.LIVE == curr) {
                    if (nCount < 2 || nCount > 3) {
                        next = State.DEAD;
                    } else {
                        next = State.LIVE;
                    }
                } else { // State.DEAD == curr
                    if (3 == nCount) {
                        next = State.LIVE;
                    } else {
                        next = State.DEAD;
                    }
                }

                new_.setCell(i, j, next);

            }
        }

        Field tmp;
        tmp = new_;
        new_ = old_;
        old_ = tmp;

        return this;
    }

}
