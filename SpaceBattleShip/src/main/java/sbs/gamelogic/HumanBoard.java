package sbs.gamelogic;

/**
 * The Human player's board. Contains method for placing the ships on the board
 * through mouse input coordinates
 *
 * @author Sampo
 */
public class HumanBoard extends Board {

    /**
     * keeps track of the size of the ship currently being placed on the board.
     */
    private int size;

    public HumanBoard(int dimension, int maxshipsize) {
        super(dimension, maxshipsize);
        if (maxshipsize > 0) {
            size = maxshipsize;
        } else {
            size = 5;
        }
        acceptClick = true;
    }

    /**
     * This method attempts to place a ship on the board. The method goes
     * through a series of checks to see whether the placement is valid There
     * are two invalid placements: either the ship goes out of board bounds, or
     * another ship already occupies one or more cells the ship would be placed
     * in if placement is not valid, the game prompts player to attempt again if
     * the placement is valid, the ship is added to the ships hashmap and the
     * next ship to be placed is one unit smaller
     *
     * @param r the row coordinate
     * @param c the column coordinate
     * @param isHorizontal whether the ship being placed is horizontal or
     * vertical orientation
     * @return returns a string for the GUI method calling this one so it can be
     * added to the battle log.
     */
    public String place(int r, int c, boolean isHorizontal) {
        //check validity of random placement, redo this method if out of bounds
        if (r < 0 || c < 0 || (!isHorizontal && r + size > row) || (isHorizontal && c + size > column)) {
            return "Ship out of bounds, please redo";
        }
        //set each of ship's cells on the board to the value "1" to signify there's a ship
        if (isHorizontal) {
            for (int i = c; i < (size + c); i++) {
                if (getCell(r, i) != 0) {
                    return "Another ship occupying this space, please redo";
                }
            }
            for (int j = c; j < size + c; j++) {
                setCell(r, j, size);
            }
        } else if (!isHorizontal) {
            for (int i = r; i < (size + r); i++) {
                if (getCell(i, c) != 0) {
                    return "Another ship occupying this space, please redo";
                }
            }
            for (int j = r; j < (size + r); j++) {
                setCell(j, c, size);
            }
        }
        if (size > 1) {
            ships.put(size, new Ship(r, c, size, isHorizontal, this));
        }
        size--;
        if (size < 2) {
            acceptClick = false;
        }
        return "" + ships.get(size + 1) + " placed.";
    }

    public void setSize(int s) {
        size = s;
    }

    public int getSize() {
        return size;
    }
}
