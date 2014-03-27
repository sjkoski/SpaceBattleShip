package sbs.spacebattleship;

import java.util.ArrayList;

public class Game {

    private Board board;
    private Player player1;
    private boolean isWinner;

    public Game(int dimension, int maxshipsize) {
        board = new Board(dimension, dimension, maxshipsize);
        player1 = new Human();
        isWinner = false;

    }

    public void play() {
        while (!isWinner) {
            player1.shoot(board);
            drawBoard(false);
            System.out.println("You have sunk " + board.checkStatus() + " ships");
            if (board.checkStatus() == board.getShipAmount()) {
                isWinner = true;
            }
        }
        System.out.println("You have won the game!");
    }

    public void drawBoard(boolean ishidden) {
        board.draw(ishidden);
    }
}
