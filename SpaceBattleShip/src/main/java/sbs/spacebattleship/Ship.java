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
    private boolean isSunk;
    private Board board;

    public Ship(int size) {
        this.size = size;
        this.board = board;
        isSunk = false;
    }

    public Ship(int r, int c, int size, boolean isHorizontal, Board board) {
        this.r = r;
        this.c = c;
        this.size = size;
        this.isHorizontal = isHorizontal;
        this.isSunk = false;
        this.board = board;
    }

    public boolean checkStatus() {
        return isSunk;
    }

    public int getHits() {
        //returns the number of hits on the ship
        int hitsTaken = 0;
        if (isHorizontal) {
            for (int i = c; i < (size + c); i++) {
                if (board.getCell(r, i) == 2) {
                    hitsTaken++;
                }
            }
        } else if (!isHorizontal) {
            for (int i = r; i < (size + r); i++) {
                if (board.getCell(r, c) == 2) {
                    hitsTaken++;
                }
            }
        }
        return hitsTaken;
    }

    public boolean isSunk() {
        if (getHits() == size) {
            isSunk = true;
        }
        return isSunk;
    }

    public int getSize() {
        return size;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }
}
