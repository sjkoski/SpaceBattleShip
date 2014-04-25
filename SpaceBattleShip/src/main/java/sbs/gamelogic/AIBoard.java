package sbs.gamelogic;

import java.util.Random;

public class AIBoard extends Board {

    private Random random;

    public AIBoard(int r, int c, int maxshipsize) {
        super(r, c, maxshipsize);
        random = new Random();
        acceptClick = false;
    }

    @Override
    public void placeShips(int maxshipsize) {
        //place ships of descending sizes on the board one by one, minimum size is 2. Adds them to an arraylist
        for (int i = maxshipsize; i > 1; i--) {
            ships.add(place(i));
        }
        System.out.println("AI ships placed");
    }

    public Ship place(int size) {
        int r = random.nextInt(row);
        int c = random.nextInt(column);
        boolean isHorizontal = random.nextBoolean();
        //check validity of random placement, redo this method if out of bounds
        if (r < 0 || c < 0 || (!isHorizontal && r + size > row) || (isHorizontal && c + size > column)) {
            return place(size);
        }
        //set each of ship's cells on the board to the value "1" to signify there's a ship
        //if a space is already occupied by another ship, redo this method
        if (isHorizontal) {
            for (int i = c; i < (size + c); i++) {
                if (getCell(r, i) == 1) {
                    return place(size);
                }
            }
            for (int j = c; j < size + c; j++) {
                setCell(r, j, 1);
            }
        } else if (!isHorizontal) {
            for (int i = r; i < (size + r); i++) {
                if (getCell(r, c) == 1) {
                    return place(size);
                }
            }
            for (int j = r; j < (size + r); j++) {
                setCell(j, c, 1);
            }
        }
        System.out.println(
                "Ship of size " + size + " placed in (" + r + "," + c + "). It's horizontal value is " + isHorizontal);
        return new Ship(r, c, size, isHorizontal, this);
    }
}
