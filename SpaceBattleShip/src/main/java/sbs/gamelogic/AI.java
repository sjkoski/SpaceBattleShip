package sbs.gamelogic;

/**
 * The AI player's class. Has method for taking a turn, that is taking a shot at human player's board
 */
import java.util.Random;

public class AI {

    private Random random;
    private Game game;

    public AI(Game game) {
        random = new Random();
        this.game = game;

    }

    /**
     * Shoots at a random cell on a board. Runs checks to see whether the target is valid
     * Target is invalid if it's been shot at before.
     * Successful shot adds 10 to the cell value to distinguish that it's been shot at.
     * 
     * @param board the board that is being shot at. 
     */
    
    public void shoot(Board board) {
        boolean valid = false;
        int r = 0;
        int c = 0;
        while (!valid) {
            r = random.nextInt(10);
            c = random.nextInt(10);
            if (board.getCell(r, c) < 10) {
                valid = true;
            }
        }
        if (board.getCell(r, c) > 0) {
            board.setCell(r, c, (board.getCell(r, c) + 10));
            game.getLog().append("\nThe enemy fires turbolasers at (" + r + " , " + c + ")! Hit!");
            if (board.getShips().get(board.getCell(r, c) - 10).isSunk()) {
                game.getLog().append("\nThe enemy blew up our " + (board.getShips().get(board.getCell(r, c) - 10)) + "!");
            }
        } else {
            board.setCell(r, c, 10);
            game.getLog().append("\nThe enemy fires turbolasers at (" + r + " , " + c + ")! Miss!");
        }
    }
}
