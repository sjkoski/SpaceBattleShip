package sbs.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sbs.gamelogic.Game;

/**
 * Listener for the New Game button
 *
 * @author Sampo
 */
class NewGameListener implements ActionListener {

    private Game game;
    private UI ui;

    public NewGameListener(UI ui, Game game) {
        this.game = game;
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.newGame();
        ui.getAIBoardPanel().repaint();
        ui.getHumanBoardPanel().repaint();
    }
}
