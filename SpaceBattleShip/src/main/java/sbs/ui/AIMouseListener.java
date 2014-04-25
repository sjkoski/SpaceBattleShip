package sbs.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import sbs.gamelogic.Game;

public class AIMouseListener extends MouseAdapter {

    private UI ui;
    private Game game;

    public AIMouseListener(UI ui, Game game) {
        this.ui = ui;
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int column = (int) Math.floor((e.getX() / 30));
        int row = (int) Math.floor((e.getY() / 30));
        if (game.getAIBoard().areClicksAccepted()) {
            String fired = game.getHuman().shoot(game.getAIBoard(), row, column);
            ui.addMessage(fired);
            ui.getAIBoardPanel().repaint();
            if (!fired.equals("We have already shelled this location")) {
                game.getAIBoard().setAcceptClick(false);
            }
        }
        //ui.setMessage("Mouse click resolves at coordinates " + row + " , " + column);
    }
}
