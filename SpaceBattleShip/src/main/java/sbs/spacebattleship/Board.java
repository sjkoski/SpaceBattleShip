package sbs.spacebattleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {

    private Random random;
    private int[][] board;
    private ArrayList<Ship> ships;
    private int row, column;

    public Board(int r, int c, int maxshipsize) {
        if (r > 0) {
            row = r;
        }
        if (c > 0) {
            column = c;
        }
        //make a board of x*y dimensions
        random = new Random();
        board = new int[row][column];
        initBoard();
        ships = new ArrayList<Ship>();
        if (maxshipsize > 0 && maxshipsize <= row && maxshipsize <= column) {
            placeShips(maxshipsize);
        }
    }

    public void initBoard() {
        //set 0 to every cell as initial value
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                board[r][c] = 0;
            }
        }
    }

    public void placeShips(int maxshipsize) {
        //place ships of descending sizes on the board one by one, minimum size is 2. Adds them to an arraylist
        for (int i = maxshipsize; i > 1; i--) {
            ships.add(place(i));
        }
    }

    public Ship place(int size) {
        int r = random.nextInt(row);
        int c = random.nextInt(column);
        boolean isHorizontal = random.nextBoolean();
        //check validity of random placement, redo this method if out of bounds
        if (r < 0 || c < 0 || (!isHorizontal && r + size > row) || (isHorizontal && c + size > column)) {
            return place(size);
        }
        //set each cell on the board to the value "1" to signify there's a ship
        if (isHorizontal) {
            for (int i = c; i < (size + c); i++) {
                setCell(r, i, 1);
            }
        }
        if (!isHorizontal) {
            for (int i = r; i < (size + r); i++) {
                setCell(i, r, 1);
            }
        }
        System.out.println("Ship of size " + size + " placed in (" + r + "," + c + "). It's horizontal value is " + isHorizontal);
        return new Ship(r, c, size, isHorizontal);

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

    public int getShipAmount() {
        return ships.size();
    }

    public void draw() {
        //Draw the current board. "-" means an empty cell, "S" an intact ship segment, "X" a hit ship segment and "O" a missed shot
        for (int a = 0; a < row; a++) {
            for (int b = 0; b < column; b++) {
                if (board[a][b] == 1) {
                    System.out.print(" S");
                } else if (board[a][b] == 2) {
                    System.out.print(" X");
                } else if (board[a][b] == 3) {
                    System.out.print(" O");
                } else {
                    System.out.print(" -");
                }
            }
            System.out.println();
        }

    }
}
