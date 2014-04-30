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
public class HumanBoardTest {

    private HumanBoard board;

    public HumanBoardTest() {
    }

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
    public void negativeDimensionDefaults() {
        board = new HumanBoard(-10, 5);
        assertEquals(10, board.column);
        assertEquals(10, board.row);
    }

    @Test
    public void negativeShipSizeDefaults() {
        board = new HumanBoard(10, -5);
        assertEquals(5, board.getSize());
    }

    @Test
    public void negativeHorizontalPlacement() {
        board = new HumanBoard(10, 5);
        String place = board.place(-1, -1, true);
        assertEquals(place, "Ship out of bounds, please redo");
    }

    @Test
    public void outOfBoundsPlacement() {
        board = new HumanBoard(10, 5);
        String place = board.place(11, 11, false);
        assertEquals(place, "Ship out of bounds, please redo");
    }
    
    @Test
    public void cantPlaceShipSmallerThanTwo() {
        board = new HumanBoard(10, 3);
        board.place(0, 0, true);
        board.place(1, 1, true);
        board.place(2, 2, true);
        assertEquals(2, board.getShips().size());
    }
}
