package sbs.spacebattleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//follows the playing board state
public class Board {

    private int[][] board;
    private ArrayList<Ship> ships;
    private int row, column, numberofships;

    public Board(int x, int y) {
        row = x;
        column = y;
        //make a board of x*y dimensions, initialize by placing value 0 in each cell
        board = new int[row][column];
        initBoard();
        //create a number of ships, place them on board
    }

    public void initBoard() {

        for (int x = 0; x < row; x++) {
            for (int y = 0; y < column; y++) {
                board[x][y] = 0;
            }
        }
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
            for (int b = 0; b < 10; b++) {
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
