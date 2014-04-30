/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sbs.gamelogic;

import javax.swing.JTextArea;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sampo
 */
public class GameTest {
    
    public GameTest() {
    }
    
    private Game game;
    private JTextArea log;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new Game(10, 5);
        log = new JTextArea();
        game.setLog(log);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void newGameClearsGame() {
        game.initGame();
        game.getHumanBoard().setCell(0, 0, 15);
        game.getHumanBoard().place(4, 4, true);
        game.initGame();
        assertEquals(0, game.getHumanBoard().getShips().size());
        assertEquals(0, game.getHumanBoard().getCell(0, 0));      
    }
}
