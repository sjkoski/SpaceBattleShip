package sbs.gamelogic;

import java.util.Random;

public class AI {

    private Random random;

    public AI() {
        random = new Random();
    }

    public String shoot(Board board) {
        boolean valid = false;
        int r = 0;
        int c = 0;
        while (!valid) {
            r = random.nextInt(10);
            c = random.nextInt(10);
            //as long as the target cell hasn't been shot at before, it's valid.
            if (board.getCell(r, c) < 2) {
                valid = true;
            }
        }
        if (board.getCell(r, c) == 1) {
            board.setCell(r, c, 2);
            return ("The enemy fires turbolasers at (" + r + " , " + c + ")! Hit!");
        } else {
            board.setCell(r, c, 3);
            return ("The enemy fires turbolasers at (" + r + " , " + c + ")! Miss!");
        }
    }
}
