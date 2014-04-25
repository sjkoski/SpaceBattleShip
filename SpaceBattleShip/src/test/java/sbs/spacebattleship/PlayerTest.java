/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sbs.spacebattleship;

import sbs.gamelogic.Human;
import sbs.gamelogic.AIBoard;
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
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    private Human player;
    private AIBoard board;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        board = new AIBoard(10, 10, 4);
    }
    
    @After
    public void tearDown() {
    }
   
    
}
