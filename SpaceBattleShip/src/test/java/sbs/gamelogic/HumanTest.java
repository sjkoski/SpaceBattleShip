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
public class HumanTest {

    private Human human;
    private Game game;
    private HumanBoard board;
    private JTextArea log;

    public HumanTest() {
    }

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
    public void negativeCoordinateShot() {
        board = new HumanBoard(10, 5);
        board.initBoard();
        human = new Human(game);
        boolean valid = human.shoot(board, -1, -1);
        assertEquals(false, valid);
    }

    @Test
    public void tooBigCoordinateShot() {
        board = new HumanBoard(10, 5);
        board.initBoard();
        human = new Human(game);
        boolean valid = human.shoot(board, 11, 11);
        assertEquals(false, valid);
    }

    @Test
    public void shootingAtShipWorks() {
        board = new HumanBoard(10, 5);
        board.initBoard();
        board.place(0, 0, true);
        human = new Human(game);
        human.shoot(board, 0, 0);
        assertEquals(15, board.getCell(0, 0));
    }

    @Test
    public void missingWorks() {
        board = new HumanBoard(10, 5);
        board.initBoard();
        human = new Human(game);
        human.shoot(board, 0, 0);
        assertEquals(10, board.getCell(0, 0));
        
    }
}
