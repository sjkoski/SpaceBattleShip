package sbs.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import sbs.gamelogic.Board;

public class AIBoardPanel extends JPanel {

    private Board board;

    public AIBoardPanel(Board board) {
        this.board = board;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        setSize(301, 301);
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
                if (board.getCell(a, b) == 2) {
                    g.fillRect((b * 30), (a * 30), 30, 30);
                }

            }
        }
        g.setColor(Color.BLUE);
        for (int a = 0; a < board.getRow(); a++) {
            for (int b = 0; b < board.getColumn(); b++) {
                if (board.getCell(a, b) == 2) {
                    g.fillOval(b * 30, a * 30, 30, 30);
                }

            }
        }
        g.setColor(Color.WHITE);
        for (int a = 0; a < board.getRow(); a++) {
            for (int b = 0; b < board.getColumn(); b++) {
                if (board.getCell(a, b) == 3) {
                    g.fillOval(b * 30, a * 30, 30, 30);
                }

            }
        }
    }

}
