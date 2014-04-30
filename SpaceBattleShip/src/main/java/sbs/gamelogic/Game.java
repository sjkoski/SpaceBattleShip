package sbs.gamelogic;

import javax.swing.JTextArea;

/**
 * The main game logic engine. Has all the machinery for running the actual
 * game.
 *
 *  * @author Sampo
 *
 */
public class Game {

    /**
     * the length of the largest ship in fleet. The smallest ship is always
     * length of 2.
     */
    private int maxshipsize;
    private HumanBoard humanboard;
    private Human humanplayer;
    private AIBoard aiboard;
    private AI aiplayer;
    private boolean gameOver;
    private boolean fleetDeployed;
    /**
     * a workaround to get the human player's board and the game log to redraw
     */
    private Updatable humanboardpanel;
    private JTextArea log;

    public Game(int dimension, int maxshipsize) {
        humanboard = new HumanBoard(dimension, maxshipsize);
        aiboard = new AIBoard(dimension, maxshipsize);
        humanplayer = new Human(this);
        aiplayer = new AI(this);
        gameOver = false;
        fleetDeployed = false;
        this.maxshipsize = maxshipsize;
    }

    /**
     * Main game loop that keeps on running once invoked. The loop first sees
     * that both players have placed their fleets Then it does a wait loop until
     * the player has played his turn (that is, taken a shot with the shoot
     * method) Following by AI taking turn with the shoot method. Game remains
     * in this loop indefinitely. The newGame method re-initialises the game.
     */
    public void play() {
        initGame();
        while (true) {
            deployFleet();
            aiboard.setAcceptClick(true);
            while (aiboard.areClicksAccepted()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                }
            }
            if (aiboard.howManySunkenShips() == (maxshipsize - 1)) {
                gameOver("You");
            }
            if (!gameOver && fleetDeployed) {
                aiplayer.shoot(humanboard);
                humanboardpanel.update();

                if (humanboard.howManySunkenShips() == (maxshipsize - 1)) {
                    gameOver("AI");
                }
            }
        }
    }

    /**
     * Called by the "New Game" button in the GUI. Resets game.
     */
    public void newGame() {
        aiboard.setAcceptClick(false);
        gameOver = false;
        initGame();
        log.append("\nNew Game!\nPlace your fleet.");
    }

    /**
     * Initialises game starting state by putting every parameter at their
     * starting values
     */
    public void initGame() {
        humanboard.setSize(maxshipsize);
        humanboard.initBoard();
        aiboard.initBoard();
        fleetDeployed = false;
    }

    /**
     * A loop that keeps running until player has placed all his ships. Is ran
     * after the new game initial state has been set after player places his
     * fleet, the AI places its fleet
     */
    private void deployFleet() {
        while (!fleetDeployed) {
            humanboard.setAcceptClick(true);
            while (humanboard.areClicksAccepted()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
            }
            if (humanboard.ships.size() == (maxshipsize - 1)) {
                fleetDeployed = true;
                log.append("\nDeployment over");
                aiboard.placeShips(maxshipsize);
                log.append("\nEnemy fleet has taken positions");
            }
        }
    }

    /**
     * Declares the game over and the winner
     *
     * @param winner either the player or the AI
     *
     */
    public void gameOver(String winner) {
        gameOver = true;
        log.append("\nGame Over! The winner is " + winner + "!");
        aiboard.setAcceptClick(false);
    }

    public HumanBoard getHumanBoard() {
        return humanboard;
    }

    public AIBoard getAIBoard() {
        return aiboard;
    }

    public Human getHuman() {
        return humanplayer;
    }

    public void setUpdatable(Updatable updatable) {
        this.humanboardpanel = updatable;
    }

    public void setLog(JTextArea log) {
        this.log = log;
    }

    public JTextArea getLog() {
        return log;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
