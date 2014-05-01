package sbs.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import sbs.gamelogic.Board;
import sbs.gamelogic.Updatable;

/**
 * Graphic implementation of the human player's board. Implements the Updatable
 * interface so that the game itself can call it
 * Technique totally stolen from the OhJa course Matopeli exercise.
 *
 * @author Sampo
 */
public class HumanBoardPanel extends JPanel implements Updatable {

    private Board board;

    public HumanBoardPanel(Board board) {
        this.board = board;
    }

    @Override
    /**
     * Draws the human player's board grid Black background Green rectangles
     * form the grid light gray filled rectangles for ships red dots for hits
     * and white dots for misses
     */
    public void paintComponent(Graphics g) {
        setSize(300, 300);
        setBackground(Color.BLACK);
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        int i = 30;
        while (i <= 300) {
            g.drawRect(0, 0, i, 300);
            i += 30;
        }
        i = 30;
        while (i <= 300) {
            g.drawRect(0, 0, 300, i);
            i += 30;
        }
        g.setColor(Color.LIGHT_GRAY);
        for (int a = 0; a < board.getRow(); a++) {
            for (int b = 0; b < board.getColumn(); b++) {
                if (board.getCell(a, b) != 0 && board.getCell(a, b) != 10) {
                    g.fillRect((b * 30), (a * 30), 30, 30);
                }

            }

        }
        g.setColor(Color.RED);
        for (int a = 0; a < board.getRow(); a++) {
            for (int b = 0; b < board.getColumn(); b++) {
                if (board.getCell(a, b) > 10) {
                    g.fillOval(b * 30, a * 30, 30, 30);
                }

            }
        }
        g.setColor(Color.WHITE);
        for (int a = 0; a < board.getRow(); a++) {
            for (int b = 0; b < board.getColumn(); b++) {
                if (board.getCell(a, b) == 10) {
                    g.fillOval(b * 30, a * 30, 30, 30);
                }

            }
        }
    }

    @Override
    public void update() {
        repaint();
    }
}
