package sbs.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import sbs.gamelogic.Game;

public class HumanMouseListener extends MouseAdapter {

    private UI ui;
    private Game game;

    public HumanMouseListener(UI ui, Game game) {
        this.ui = ui;
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int column = (int) Math.floor((e.getX() / 30));
        int row = (int) Math.floor((e.getY() / 30));
        if (game.getHumanBoard().areClicksAccepted()) {
            ui.addMessage(game.getHumanBoard().place(row, column, SwingUtilities.isLeftMouseButton(e)));
            ui.getHumanBoardPanel().repaint();
        }
        //ui.setMessage("Mouse click resolves at coordinates " + row + " , " + column);
    }
}
