package sbs.spacebattleship;

import java.util.ArrayList;

public class Game {

    private Board humanboard;
    private Board aiboard;
    private Player humanplayer;
    private Player aiplayer;
    private boolean gameOver;
    private String winner;

    public Game(int dimension, int maxshipsize) {
        humanboard = new HumanBoard(dimension, dimension, maxshipsize);
        aiboard = new AIBoard(dimension, dimension, maxshipsize);
        humanplayer = new Human();
        aiplayer = new AI();
        gameOver = false;
        winner = "";

    }

    public void play() {
        while (!gameOver) {
            humanplayer.shoot(aiboard);
            drawBoard(aiboard, true);
            System.out.println("You have sunk " + aiboard.howManySunkenShips() + " ships");
            if (aiboard.howManySunkenShips() == aiboard.getShipAmount()) {
                gameOver = true;
                winner = "You";
            }
            aiplayer.shoot(humanboard);
            drawBoard(humanboard, false);
            System.out.println("The AI has sunk " + humanboard.howManySunkenShips() + " ships");
            if (humanboard.howManySunkenShips() == humanboard.getShipAmount()) {
                gameOver = true;
                winner = "AI";
            }
        }
        System.out.println("The game has ended! The winner is " + winner);
    }

    public void drawBoard(Board board, boolean ishidden) {
        board.draw(ishidden);
    }
}
