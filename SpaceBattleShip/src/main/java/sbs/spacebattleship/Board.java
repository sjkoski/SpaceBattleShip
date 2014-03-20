package sbs.spacebattleship;

import java.util.ArrayList;
import java.util.List;

//follows the playing board state
public class Board {

    private int[][] board;
    private ArrayList<Ship> ships;
    private int row, column;

    public Board(int x, int y) {
        row = x;
        column = y;
        //make a board of x*y dimensions, place 0 in each cell
        board = new int[row][column];

        for (int a = 0; x < row; x++) {
            for (int b = 0; y < column; y++) {
                board[a][b] = 0;
            }
        }
        ships = new ArrayList<Ship>();
    }

    public void placeShip(Ship ship) {
    }

    public void draw() {
        for (int a = 0; a < row; a++) {
            for (int b = 0; b < 10; b++) {
                if (board[a][b] == 0) {
                    System.out.print("\t" + "-");
                } else if (board[a][b] == 0) {
                    System.out.print("\t" + "*");
                } else if (board[a][b] == 1) {
                    System.out.print("\t" + "X");
                }

            }
                            System.out.println();
        }

    }
}
