package sbs.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import sbs.gamelogic.Game;
/**
 * Mouse event listener for the AI grid. Event triggers when mouse is clicked while cursor is on top of the grid
 * @author Sampo
 */
public class AIMouseListener extends MouseAdapter {

    private UI ui;
    private Game game;

    public AIMouseListener(UI ui, Game game) {
        this.ui = ui;
        this.game = game;
    }

    @Override
    /**
     * When the human player clicks on the enemy grid, this method transforms the cursor coordinates to board cell coordinates 
     * and then if it's actually the player's turn to shoot, calls the shoot method
     * if the shot was in valid coordinates, passes the turn
     */
    public void mouseClicked(MouseEvent e) {
        int column = (int) Math.floor((e.getX() / 30));
        int row = (int) Math.floor((e.getY() / 30));
        if (game.getAIBoard().areClicksAccepted() && !game.isGameOver()) {
            boolean shotValid = game.getHuman().shoot(game.getAIBoard(), row, column);
            ui.getAIBoardPanel().repaint();
            if (shotValid) {
                game.getAIBoard().setAcceptClick(false);
            }
        }
    }
}
