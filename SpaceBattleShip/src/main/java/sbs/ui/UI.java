package sbs.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import sbs.gamelogic.Game;

public class UI implements Runnable {

    private JFrame frame;
    private Game game;
    private JTextArea log;
    private HumanBoardPanel humanBoardPanel;
    private AIBoardPanel aiBoardPanel;
    private Font font;
    private Font logfont;
    private Font uifont;

    public UI(Game game) {
        this.game = game;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/Bank Gothic Light BT.ttf"));
        } catch (IOException | FontFormatException e) {
            //Handle exception
        }
        logfont = new Font("Verdana", Font.PLAIN, 13);
        uifont = new Font("Verdana", Font.BOLD, 12);


    }

    @Override
    public void run() {
        frame = new JFrame("SpaceBattleShips");
        frame.setPreferredSize(new Dimension(720, 520));
        frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    public void createComponents(Container container) {
        container.setLayout(new BorderLayout(2, 1));
        JPanel boards = new JPanel();
        boards.setBackground(Color.BLACK);
        Border outerBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        boards.setBorder(outerBorder);
        boards.setLayout(new GridLayout(1, 2, 50, 0));

        JPanel bottom = new JPanel();
        bottom.setPreferredSize(new Dimension(720, 140));
        bottom.setBackground(Color.BLACK);
        bottom.setBorder(outerBorder);

        log = new JTextArea(4, 20);
        log.setBackground(Color.BLACK);
        log.setEditable(false);
        log.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(log);
        scroll.setBackground(Color.BLACK);
        scroll.setPreferredSize(new Dimension(400, 100));


        Border lineBorder = BorderFactory.createLineBorder(Color.GREEN);
        Border logBorder = BorderFactory.createTitledBorder(lineBorder, "Battle Log", TitledBorder.RIGHT, TitledBorder.TOP, uifont, Color.green);
        log.setFont(logfont);
        scroll.setBorder(logBorder);
        log.setText("Welcome To SpaceBattleShips! \nPlace your fleet on the left side grid. \nLeft mouse button places ship horizontally. \nRight mouse button places ship vertically.");
        //log.setFont(font);
        log.setForeground(Color.GREEN);

        JButton newgame = new JButton("New Game");
        newgame.setBackground(Color.GREEN);
        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.newgame();
                log.append("\nNew Game!\nPlace your fleet.");
                aiBoardPanel.repaint();
                humanBoardPanel.repaint();
            }
        });


        bottom.add(scroll);
        bottom.add(newgame);

        humanBoardPanel = new HumanBoardPanel(game.getHumanBoard());
        humanBoardPanel.addMouseListener(new HumanMouseListener(this, game));
        aiBoardPanel = new AIBoardPanel(game.getAIBoard());
        aiBoardPanel.addMouseListener(new AIMouseListener(this, game));
        boards.add(humanBoardPanel);
        boards.add(aiBoardPanel);

        container.add(boards, BorderLayout.CENTER);
        container.add(bottom, BorderLayout.SOUTH);

    }

    public void addMessage(String message) {
        log.append("\n" + message);
    }

    public HumanBoardPanel getHumanBoardPanel() {
        return humanBoardPanel;
    }

    public AIBoardPanel getAIBoardPanel() {
        return aiBoardPanel;
    }
    
    public JTextArea getLog() {
        return log;
    }
}
