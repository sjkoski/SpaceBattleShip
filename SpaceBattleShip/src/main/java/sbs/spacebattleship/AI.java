package sbs.spacebattleship;

import java.util.Random;

public class AI implements Player {

    private Random random;

    public AI() {
        random = new Random();
    }

    @Override
    public boolean shoot(Board board) {
        boolean valid = false;
        int r = 0;
        int c = 0;
        while (!valid) {
            r = random.nextInt(10);
            c = random.nextInt(10);
            if (board.getCell(r, c) < 2) {
                valid = true;
            }
        }
        if (board.getCell(r, c) == 1) {
            System.out.println("Hit!");
            board.setCell(r, c, 2);
            return true;
        } else {
            System.out.println("Miss!");
            board.setCell(r, c, 3);
            return false;
        }
    }
}
