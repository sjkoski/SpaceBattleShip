package sbs.spacebattleship;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    public BoardTest() {
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
        board = new AIBoard(10, 10, 0);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void shipSizeofZero() {
        Ship ship = board.place(0);
        assertEquals(0, board.getCell(ship.getR(), ship.getC()));
        
    }
    
    @Test
    public void negativeShipSize() {
        Ship ship = board.place(-1);
        assertEquals(0, board.getShipAmount());
    }
}
