/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sbs.spacebattleship;

import sbs.gamelogic.AIBoard;
import sbs.gamelogic.Board;
import sbs.gamelogic.Ship;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ShipTest {
    
    public ShipTest() {
    }
    
    private Ship ship;
    private Board board;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        board = new AIBoard(10, 10, 5);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void hittingWorks() {
        ship = new Ship(0, 0, 5, true, board);
        board.setCell(0, 0, 2);
        board.setCell(0, 3, 2);
        assertEquals(2, ship.getHits());
    }
    
    public void sinkingWorks() {
        ship = new Ship(0, 0, 2, true, board);
        board.setCell(0, 0, 2);
        board.setCell(0, 1, 2);
        assertEquals(true, ship.isSunk());
    }
    
}
