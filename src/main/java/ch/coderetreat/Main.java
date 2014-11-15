package ch.coderetreat;

import ch.coderetreat.engine.GameOfLifeEngine;
import ch.coderetreat.field.Field;

public class Main {

    public static void main(String... args) throws InterruptedException {
        final GameOfLifeEngine gole = new GameOfLifeEngine(5, 5);

        gole.getOld_().setCell(0, 0, Field.State.DEAD);
        gole.getOld_().setCell(0, 1, Field.State.DEAD);
        gole.getOld_().setCell(0, 2, Field.State.DEAD);
        gole.getOld_().setCell(0, 3, Field.State.DEAD);
        gole.getOld_().setCell(0, 4, Field.State.DEAD);

        gole.getOld_().setCell(1, 0, Field.State.DEAD);
        gole.getOld_().setCell(1, 1, Field.State.DEAD);
        gole.getOld_().setCell(1, 2, Field.State.DEAD);
        gole.getOld_().setCell(1, 3, Field.State.DEAD);
        gole.getOld_().setCell(1, 4, Field.State.DEAD);

        gole.getOld_().setCell(2, 0, Field.State.DEAD);
        gole.getOld_().setCell(2, 1, Field.State.LIVE);
        gole.getOld_().setCell(2, 2, Field.State.LIVE);
        gole.getOld_().setCell(2, 3, Field.State.LIVE);
        gole.getOld_().setCell(2, 4, Field.State.DEAD);

        gole.getOld_().setCell(3, 0, Field.State.DEAD);
        gole.getOld_().setCell(3, 1, Field.State.DEAD);
        gole.getOld_().setCell(3, 2, Field.State.DEAD);
        gole.getOld_().setCell(3, 3, Field.State.DEAD);
        gole.getOld_().setCell(3, 4, Field.State.DEAD);

        gole.getOld_().setCell(4, 0, Field.State.DEAD);
        gole.getOld_().setCell(4, 1, Field.State.DEAD);
        gole.getOld_().setCell(4, 2, Field.State.DEAD);
        gole.getOld_().setCell(4, 3, Field.State.DEAD);
        gole.getOld_().setCell(4, 4, Field.State.DEAD);

        System.out.println(gole.getOld_());

        while (true) {
            gole.step();
            System.out.println(gole.getOld_());
            Thread.sleep(1000);
        }
    }

}
