/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sbs.gamelogic;

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
public class AIBoardTest {

    public AIBoardTest() {
    }
    private AIBoard board;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void placeAndClearShipsWorks() {
        board = new AIBoard(10, 5);
        board.placeShips(5);
        board.initBoard();
        assertEquals(0, board.getShips().size());
    }

    @Test
    public void placingZeroShips() {
        board = new AIBoard(10, 5);
        board.placeShips(0);
        assertEquals(0, board.getShips().size());
    }

    @Test
    public void correctAmountOfShips() {
        board = new AIBoard(10, 5);
        board.placeShips(7);
        assertEquals(6, board.getShips().size());
    }
}
