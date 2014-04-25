package sbs.gamelogic;

import javax.swing.JTextArea;


public class Game {

    private Board humanboard;
    private int maxshipsize;
    private Board aiboard;
    private Human humanplayer;
    private AI aiplayer;
    private boolean gameOver;
    private String winner;
    private String message;
    private Updatable humanboardpanel;
    private JTextArea log;

    public Game(int dimension, int maxshipsize) {
        humanboard = new HumanBoard(dimension, dimension, maxshipsize);
        aiboard = new AIBoard(dimension, dimension, maxshipsize);
        humanplayer = new Human();
        aiplayer = new AI();
        gameOver = false;
        this.maxshipsize = maxshipsize;
        winner = "";

    }

    public void play() {
        System.out.println("Welcome to SpaceBattleShip!");
        message = "Welcome to SpaceBattleShip!";
        humanboard.initBoard(maxshipsize);
        System.out.println("Place your fleet");
        while (humanboard.areClicksAccepted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("");
            }
        }
        System.out.println("Deployment over");
        message = "Deployment over";
        aiboard.initBoard(maxshipsize);
        aiboard.placeShips(maxshipsize);
        message = "Enemy fleet has taken positions";
        while (!gameOver) {
            aiboard.setAcceptClick(true);
            while (aiboard.areClicksAccepted()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    System.out.println("");
                }
            }
            drawBoard(aiboard, true);
            System.out.println("You have sunk " + aiboard.howManySunkenShips() + " ships");
            if (aiboard.howManySunkenShips() == aiboard.getShipAmount()) {
                gameOver = true;
                winner = "You";
                log.append("\nGame Over! The winner is You!");
            }
            //log.append("\n" + aiplayer.shoot(humanboard));
            aiplayer.shoot(humanboard);
            humanboardpanel.update();
            
            drawBoard(humanboard, false);
            System.out.println("The AI has sunk " + humanboard.howManySunkenShips() + " ships");
            if (humanboard.howManySunkenShips() == humanboard.getShipAmount()) {
                gameOver = true;
                winner = "AI";
                log.append("\nGame Over! The winner is AI!");
            }
        }
        System.out.println("The game has ended! The winner is " + winner);
    }

    public void drawBoard(Board board, boolean ishidden) {
        board.draw(ishidden);
    }

    public String getMessage() {
        return message;
    }

    public Board getHumanBoard() {
        return humanboard;
    }

    public Board getAIBoard() {
        return aiboard;
    }

    public Human getHuman() {
        return humanplayer;
    }

    public void setUpdatable(Updatable updatable) {
        this.humanboardpanel = updatable;
    }

    public void newgame() {
        aiboard.initBoard(maxshipsize);
        humanboard.initBoard(maxshipsize);
        humanboard.placeShips(maxshipsize);
        
    }

    public void setLog(JTextArea log) {
        this.log = log;
    }
}
