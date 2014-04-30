package sbs.gamelogic;

/**
 * This class describes the properties of the ships that are on the playing
 * boards
 *
 * @author Sampo
 */
public class Ship {

    /**
     * ship's coordinates, length, whether it's horizontal, its status and which board it is on.
     */
    private int r;
    private int c;
    private int size;
    private boolean isHorizontal;
    private boolean isSunk;
    private Board board;

    public Ship(int r, int c, int size, boolean isHorizontal, Board board) {
        this.r = r;
        this.c = c;
        this.size = size;
        this.isHorizontal = isHorizontal;
        this.isSunk = false;
        this.board = board;
    }

    /**
     * counts the number of segments of the ship that have been hit
     *
     * @return returns the number of hits
     */
    public int getHits() {
        int hitsTaken = 0;
        if (isHorizontal) {
            for (int i = c; i < (size + c); i++) {
                if (board.getCell(r, i) == (size + 10)) {
                    hitsTaken++;
                }
            }
        } else if (!isHorizontal) {
            for (int i = r; i < (size + r); i++) {
                if (board.getCell(i, c) == (size + 10)) {
                    hitsTaken++;
                }
            }
        }
        return hitsTaken;
    }

    /**
     * If all the ship's segments have been hit, the ship is sunk
     *
     * @return true if ship is sunk
     */
    public boolean isSunk() {
        if (getHits() == size) {
            isSunk = true;
        }
        return isSunk;
    }

    public int getSize() {
        return size;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public String getShipName() {
        if (size == 6) {
            return "Mothership";
        } else if (size == 5) {
            return "Dreadnought";
        } else if (size == 4) {
            return "Battlecruiser";
        } else if (size == 3) {
            return "Destroyer";
        } else {
            return "Frigate";
        }
    }

    @Override
    public String toString() {
        return getShipName();
    }
}
