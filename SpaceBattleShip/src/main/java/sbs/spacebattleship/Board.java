package sbs.spacebattleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//follows the playing board state
public class Board {

    private Random random;
    private int[][] board;
    private ArrayList<Ship> ships;
    private int row, column;

    public Board(int r, int c, int maxshipsize) {
        row = r;
        column = c;
        //make a board of x*y dimensions
        random = new Random();
        board = new int[row][column];
        initBoard();
        ships = new ArrayList<Ship>();
        placeShips(maxshipsize, board);
    }

    public void initBoard() {
        //set 0 to every cell
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                board[r][c] = 0;
            }
        }
    }

    public void placeShips(int maxshipsize, int[][] board) {
        for (int i = maxshipsize; i > 1; i--) {
            ships.add(place(i));
        }
    }

    public Ship place(int size) {
        int r = random.nextInt(row);
        int c = random.nextInt(column);
        boolean isHorizontal = random.nextBoolean();
        //check for out of bounds, redo if fail
        if (r < 0 || c < 0 || (!isHorizontal && r + size > row) || (isHorizontal && c + size > column)) {
            return place(size);
        }
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

    public void draw() {
        for (int a = 0; a < row; a++) {
            for (int b = 0; b < column; b++) {
                if (board[a][b] == 0) {
                    System.out.print("\t" + "-");
                } else if (board[a][b] == 1) {
                    System.out.print("\t" + "S");
                } else if (board[a][b] == 2) {
                    System.out.print("\t" + "X");
                } else if (board[a][b] == 3) {
                    System.out.print("\t" + "O");
                }

            }
            System.out.println();
        }

    }
}
