package sbs.spacebattleship;

import java.util.ArrayList;


public abstract class Board {

    protected int[][] board;
    protected ArrayList<Ship> ships;
    protected int row, column;

    public Board(int r, int c, int maxshipsize) {
        if (r > 0) {
            this.row = r;
        }
        if (c > 0) {
            this.column = c;
        }
        //make a board of x*y dimensions and place ships on it
        board = new int[row][column];
        ships = new ArrayList<>();
        
    }

    public void initBoard(int maxshipsize) {
        //set 0 to every cell as initial value
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                board[r][c] = 0;
            }
        }
        if (maxshipsize > 0 && maxshipsize <= row && maxshipsize <= column) {
            placeShips(maxshipsize);
        }
    }

    public void placeShips(int maxshipsize) {
    }

    public void draw(boolean ishidden) {
        //Draw the current board. "-" means an empty cell, "S" an intact ship segment, "X" a hit ship segment and "O" a missed shot
        // if variable ishidden is true, ship locations are not shown
        for (int a = 0; a < row; a++) {
            for (int b = 0; b < column; b++) {
                if (board[a][b] == 1 && !ishidden) {
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

    public int howManySunkenShips() {
        //counts the number of sunk ships
        int sunkShips = 0;
        for (Ship ship : ships) {
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

    public int getShipAmount() {
        return ships.size();
    }
}
