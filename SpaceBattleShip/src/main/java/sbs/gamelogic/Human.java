package sbs.gamelogic;

/**
 * The human player class. Has method for taking a turn
 * 
 * @author Sampo
 */
public class Human {

    private Game game;

    public Human(Game game) {
        this.game = game;
    }

    /**
     * Shoots at the board cell given by the parameters r and c. 
     * Invokes a message and a boolean return value depending on the result of the shot (which depends on the cell's value)
     * successful shot adds 10 to the cell value to show it's been shot at
     * 
     * @param board 
     * @param r the row coordinate
     * @param c the column coordinate
     * @return the boolean is false if the given coordinates were invalid, i.e. the cell had been shot at before.
     */
    public boolean shoot(Board board, int r, int c) {
        if (r < 0 || c < 0 || r > board.getRow() || c > board.getColumn()) {
            return false;
        }
        if (board.getCell(r, c) >= 10) {
            game.getLog().append("\nWe have already shelled this location");
            return false;
        } else if (board.getCell(r, c) != 0) {
            board.setCell(r, c, (board.getCell(r, c) + 10));
            game.getLog().append("\nWe launch proton torpedoes at (" + r + " , " + c + ")! Hit!");
            if (board.getShips().get(board.getCell(r, c) - 10).isSunk()) {
                game.getLog().append("\nWe destroyed enemy " + (board.getShips().get(board.getCell(r, c) - 10)) + "!");
            }
            return true;
        } else {
            board.setCell(r, c, 10);
            game.getLog().append("\nWe launch proton torpedoes at (" + r + " , " + c + ")! Miss!");
            return true;
        }
    }
}
