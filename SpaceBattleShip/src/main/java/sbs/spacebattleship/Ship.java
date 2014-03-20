/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sbs.spacebattleship;

public class Ship {
   
    private int r;
    private int c;
    private boolean isHorizontal;
    private int size;
    private int hitsTaken;
    private boolean isSunk;
    
    public Ship(int size) {
        this.size = size;
        isSunk = false;
        hitsTaken = 0;
    }
    
    public Ship(int r, int c, int size, boolean isHorizontal) {
        this.r = r;
        this.c = c;
        this.size = size;
        this.isHorizontal = isHorizontal;
        this.hitsTaken = 0;
        this. isSunk = false;
    }

    public int getSize() {
        return size;
    }
    
    

} 
