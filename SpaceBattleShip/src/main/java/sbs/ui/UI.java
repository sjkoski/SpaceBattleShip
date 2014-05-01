package sbs.ui;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;
import sbs.gamelogic.Game;

/**
 * Game GUI main class. Methods for building and running the GUI
 *
 * @author Sampo
 */
public class UI implements Runnable {

    private JFrame frame;
    private Game game;
    private JTextArea log;
    private HumanBoardPanel humanBoardPanel;
    private AIBoardPanel aiBoardPanel;
    private Font logfont;
    private Font uifont;

    public UI(Game game) {
        this.game = game;
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

    /**
     * GUI is made of two elements, boards and bottom, that are on top of each
     * other boards is a JPanel that contains the playing boards (also JPanels)
     * bottom contains the battle log (JTextArea inside a JScrollPane) and the
     * new game button (JButton)
     *
     * @param container
     */
    public void createComponents(Container container) {
        container.setLayout(new BorderLayout(2, 1));
        
        JPanel boards = new JPanel();
        boards.setBackground(Color.BLACK);
        Border outerBorder = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        boards.setBorder(outerBorder);
        boards.setLayout(new GridLayout(1, 2, 50, 0));
        humanBoardPanel = new HumanBoardPanel(game.getHumanBoard());
        humanBoardPanel.addMouseListener(new HumanMouseListener(this, game));
        aiBoardPanel = new AIBoardPanel(game.getAIBoard());
        aiBoardPanel.addMouseListener(new AIMouseListener(this, game));
        Border lineBorder = BorderFactory.createLineBorder(Color.GREEN);
        aiBoardPanel.setBorder(lineBorder);
        humanBoardPanel.setBorder(lineBorder);
        boards.add(humanBoardPanel);
        boards.add(aiBoardPanel);

        JPanel bottom = new JPanel();
        bottom.setPreferredSize(new Dimension(720, 140));
        bottom.setBackground(Color.BLACK);
        bottom.setBorder(outerBorder);

        log = new JTextArea(4, 20);
        log.setBackground(Color.BLACK);
        log.setEditable(false);
        log.setLineWrap(true);
        log.setFont(logfont);
        log.setText("Welcome To SpaceBattleShips! \nPlace your fleet on the left side grid. \nLeft mouse button places ship horizontally. \nRight mouse button places ship vertically.");
        log.setForeground(Color.GREEN);
        DefaultCaret caret = (DefaultCaret) log.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        JScrollPane scroll = new JScrollPane(log);
        scroll.setBackground(Color.BLACK);
        scroll.setPreferredSize(new Dimension(400, 100));        
        Border logBorder = BorderFactory.createTitledBorder(lineBorder, "Battle Log", TitledBorder.RIGHT, TitledBorder.TOP, uifont, Color.green);
        scroll.setBorder(logBorder);

        JButton newgame = new JButton("New Game");
        newgame.setBackground(Color.GREEN);
        newgame.addActionListener(new NewGameListener(this, game));

        bottom.add(scroll);
        bottom.add(newgame);

        container.add(boards, BorderLayout.CENTER);
        container.add(bottom, BorderLayout.SOUTH);
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
