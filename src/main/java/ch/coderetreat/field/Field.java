package ch.coderetreat.field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Field {

    public static enum State {
        LIVE,
        DEAD
    }

    private final int width;
    private final int height;
    private final State state[][];

    public Field(final int width, final int height) {
        assert width > 0;
        assert height > 0;
        this.width = width;
        this.height = height;
        this.state = new State[width][height];
    }

    public State getCell(final int x, final int y) {
        return state[x][y];
    }

    public Field setCell(final int x, final int y, final State value) {
        state[x][y] = value;
        return this;
    }

    public List<State> getNeighbours(final int x, final int y) {
        final List<State> res = new ArrayList<>();

        int startX = x - 1, startY = y - 1;
        int endX = x + 1, endY = y + 1;

        if (startX < 0) ++startX;
        if (startY < 0) ++startY;
        if (endX >= width) --endX;
        if (endY >= height) --endY;

        for (int i = startX; i <= endX; ++i) {
            for (int j = startY; j <= endY; ++j) {
                if (x == i && y == j) continue;
                res.add(state[i][j]);
            }
        }
        return res;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                sb.append(State.LIVE == state[i][j] ? '#' : '.');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
