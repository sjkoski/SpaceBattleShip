package sbs.spacebattleship;

import java.util.Scanner;

public class HumanBoard extends Board {

    private Scanner reader;

    public HumanBoard(int r, int c, int maxshipsize) {
        super(r, c, maxshipsize);
        reader = new Scanner(System.in);
        initBoard(maxshipsize);
    }

    @Override
    public void placeShips(int maxshipsize) {
        System.out.println("Place your fleet");
        super.draw(false);
        //place ships of descending sizes on the board one by one, minimum size is 2. Adds them to an arraylist
        for (int i = maxshipsize; i > 1; i--) {
            ships.add(place(i));
        }
    }

    public Ship place(int size) {
        System.out.println("Placing ship size of " + size);
        System.out.print("Give row (0-9): ");
        int r = reader.nextInt();
        System.out.print("Give column (0-9): ");
        int c = reader.nextInt();
        System.out.print("Give orientation (1 = horizontal, any other number = vertical): ");
        boolean isHorizontal = (reader.nextInt() == 1);
        //check validity of random placement, redo this method if out of bounds
        if (r < 0 || c < 0 || (!isHorizontal && r + size > row) || (isHorizontal && c + size > column)) {
            System.out.println("Ship out of bounds, please redo");
            return place(size);
        }
        //set each of ship's cells on the board to the value "1" to signify there's a ship
        //if a space is already occupied by another ship, redo this method
        if (isHorizontal) {
            for (int i = c; i < (size + c); i++) {
                if (getCell(r, i) == 1) {
                    System.out.println("Another ship occupying this space, please redo");
                    return place(size);
                }
            }
            for (int j = c; j < size + c; j++) {
                setCell(r, j, 1);
            }
        } else if (!isHorizontal) {
            for (int i = r; i < (size + r); i++) {
                if (getCell(r, c) == 1) {
                    System.out.println("Another ship occupying this space, please redo");
                    return place(size);
                }
            }
            for (int j = r; j < (size + r); j++) {
                setCell(j, c, 1);
            }
        }
        System.out.println(
                "Ship of size " + size + " placed in (" + r + "," + c + "). It's horizontal value is " + isHorizontal);
        super.draw(false);
        return new Ship(r, c, size, isHorizontal, this);
    }
}
