package sbs.gamelogic;

import java.util.HashMap;

/**
  * Abstract class for the game boards. Human and AI versions extend this in
 * different ways. Has methods that are necessary for keeping track and
 * manipulating the game state.
 *
 *  * @author Sampo
 */
public abstract class Board {

    /**
     * the actual board is an int[][] array that represents the rows and
     * columns. The cell values represent the following: 0 = empty cell 10 =
     * empty cell that has been shot 2-9 = segment of a ship with that size, e.g
     * value of 3 means a section of a 3-length ship is in this cell 12-19 =
     * segment of a ship with size 2-9 as above, that has been shot at.
     */
    protected int[][] board;
    /**
     * A hashmap of the ships on the board. The key is the length of a ship,
     * since there's only one ship of each size.
     */
    protected HashMap<Integer, Ship> ships;
    protected int row, column;
    /**
     * Whether mouse clicks on the GUI on this board register or not,
     * essentially equivalent to whose turn it is in the game.
     */
    protected boolean acceptClick;

    public Board(int dimension, int maxshipsize) {
        if (dimension > 0) {
            this.row = dimension;
            this.column = dimension;
        } else {
            this.row = 10;
            this.column = 10;
        }
        board = new int[row][column];
        ships = new HashMap<>();
        acceptClick = false;

    }

    /**
     * Removes all ships from the board and sets the value 0 to all cells Used
     * every time a new game begins.
     */
    public void initBoard() {
        getShips().clear();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                board[r][c] = 0;
            }
        }
    }

    /**
     *
     * @return returns the number of destroyed ships. Used for checking whether
     * the game is over.
     */
    public int howManySunkenShips() {
        int sunkShips = 0;
        for (Ship ship : ships.values()) {
            if (ship.isSunk()) {
                sunkShips++;
            }
        }
        return sunkShips;

    }

    public void setCell(int r, int c, int v) {
        board[r][c] = v;
    }

    public int getCell(int r, int c) {
        return board[r][c];
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public HashMap<Integer, Ship> getShips() {
        return ships;
    }

    public boolean areClicksAccepted() {
        return acceptClick;
    }

    public void setAcceptClick(boolean b) {
        acceptClick = b;
    }
}
