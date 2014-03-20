package sbs.spacebattleship;

import java.util.ArrayList;

public class Game {

    private Board board;
    private ArrayList<Ship> ships;

    public Game(int dimension, int numberofships) {
        board = new Board(dimension, dimension);
        ships = new ArrayList<Ship>();
        placeShips(numberofships, board);
    }

    public void placeShips(int numberofships, Board board) {
        for (int i = numberofships; i > 1; i--) {
            ships.add(new Ship(i));
        }
        for (Ship ship : ships) {
            ship.place(board);

        }
    }

    public void drawBoard() {
        board.draw();
    }
}
