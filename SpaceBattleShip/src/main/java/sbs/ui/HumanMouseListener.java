package sbs.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import sbs.gamelogic.Game;

/**
 * Mouse listener for the human player's board.
 * 
 * @author Sampo
 */
public class HumanMouseListener extends MouseAdapter {

    private UI ui;
    private Game game;

    public HumanMouseListener(UI ui, Game game) {
        this.ui = ui;
        this.game = game;
    }

    /**
     * When the human player clicks on his own grid, this method transforms the
     * cursor coordinates to board cell coordinates and then if it's the fleet
     * deployment phase (clicks accepted), calls the ships placing method on that cell
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int column = (int) Math.floor((e.getX() / 30));
        int row = (int) Math.floor((e.getY() / 30));
        if (game.getHumanBoard().areClicksAccepted()) {
            ui.getHumanBoardPanel().repaint();
            ui.getLog().append("\n" + game.getHumanBoard().place(row, column, SwingUtilities.isLeftMouseButton(e)));

        }
    }
}
