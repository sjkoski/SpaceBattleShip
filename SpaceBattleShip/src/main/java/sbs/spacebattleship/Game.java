package sbs.spacebattleship;

import java.util.ArrayList;

public class Game {

    private Board board;


    public Game(int dimension, int maxshipsize) {
        board = new Board(dimension, dimension, maxshipsize);

    }


    public void drawBoard() {
        board.draw();
    }
}
