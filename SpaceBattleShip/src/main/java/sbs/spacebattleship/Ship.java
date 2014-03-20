/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sbs.spacebattleship;

import java.util.Random;

public class Ship {
   
    private int x;
    private int y;
    private boolean isHorizontal;
    private int size;
    private int hitsTaken;
    private boolean isSunk;
    
    public Ship(int size) {
        this.size = size;
        isSunk = false;
        hitsTaken = 0;
    }
    
    public void place(Board board) {
        Random random = new Random();
        x = random.nextInt(board.getRow());
        y = random.nextInt(board.getColumn());
        int ishoriz = random.nextInt(1);
        isHorizontal = (ishoriz == 0);
        
    }
} 
