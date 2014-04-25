package sbs;

import javax.swing.SwingUtilities;
import sbs.gamelogic.*;
import sbs.ui.UI;

public class App {

    public static void main(String[] args) {

        Game game = new Game(10, 5);
        UI ui = new UI(game);
        SwingUtilities.invokeLater(ui);
        while (ui.getHumanBoardPanel() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("No updatable yet");
            }
        }

        game.setUpdatable(ui.getHumanBoardPanel());
        game.setLog(ui.getLog());
        game.play();


    }
}
