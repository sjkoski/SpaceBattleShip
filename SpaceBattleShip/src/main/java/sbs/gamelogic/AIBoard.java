package sbs.gamelogic;

import java.util.Random;

/**
 * Class for the AI player's game board. Contains methods for populating the board randomly with the fleet
 * 
 * @author Sampo
 */
public class AIBoard extends Board {

    private Random random;

    public AIBoard(int dimension, int maxshipsize) {
        super(dimension, maxshipsize);
        random = new Random();
    }

    /**
     * Method that repeatedly calls the place method until the correct number of ships has been placed
     * Ships are placed in order of descending sizes from the given maximum size down to the minimum of size 2
     * 
     * @param maxshipsize the size of the longest ship
     */
    public void placeShips(int maxshipsize) {
        for (int i = maxshipsize; i > 1; i--) {
            ships.put(i, place(i));
        }
    }

    /**
     * Attempts to place a ship on the board by going through a series of checks. Calls itself repeatedly until it hits a placement that is valid
     * 
     * @param size the size of the ship being placed
     * @return once a valid placement has been found, returns the ship to the placeships method
     */
    public Ship place(int size) {
        int r = random.nextInt(row);
        int c = random.nextInt(column);
        boolean isHorizontal = random.nextBoolean();
        if (r < 0 || c < 0 || (!isHorizontal && r + size > row) || (isHorizontal && c + size > column)) {
            return place(size);
        }
        if (isHorizontal) {
            for (int i = c; i < (size + c); i++) {
                if (getCell(r, i) != 0) {
                    return place(size);
                }
            }
            for (int j = c; j < size + c; j++) {
                setCell(r, j, size);
            }
        } else if (!isHorizontal) {
            for (int i = r; i < (size + r); i++) {
                if (getCell(i, c) != 0) {
                    return place(size);
                }
            }
            for (int j = r; j < (size + r); j++) {
                setCell(j, c, size);
            }
        }
        return new Ship(r, c, size, isHorizontal, this);
    }
}
