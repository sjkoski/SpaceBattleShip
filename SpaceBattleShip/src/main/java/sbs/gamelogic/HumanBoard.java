package sbs.gamelogic;

public class HumanBoard extends Board {
    
    private int size;
    
    public HumanBoard(int r, int c, int maxshipsize) {
        super(r, c, maxshipsize);
        size = maxshipsize;
        acceptClick = true;
        
    }
    
    @Override
    public void placeShips(int maxshipsize) {
        System.out.println("Place your fleet");
        super.draw(false);
        acceptClick = true;
        while (areClicksAccepted()) {
        }
        System.out.println("Deployment over");
    }
    
    public String place(int r, int c, boolean isHorizontal) {

        //System.out.print("Give row (0-9): ");
        //int r = reader.nextInt();
        //System.out.print("Give column (0-9): ");
        //int c = reader.nextInt();
        //System.out.print("Give orientation (1 = horizontal, any other number = vertical): ");
        //boolean isHorizontal = (reader.nextInt() == 1);

        //check validity of random placement, redo this method if out of bounds
        if (r < 0 || c < 0 || (!isHorizontal && r + size > row) || (isHorizontal && c + size > column)) {         
            return "Ship out of bounds, please redo";
        }
        //set each of ship's cells on the board to the value "1" to signify there's a ship
        if (isHorizontal) {
            for (int i = c; i < (size + c); i++) {
                if (getCell(r, i) == 1) {
                    return "Another ship occupying this space, please redo";
                }
            }
            for (int j = c; j < size + c; j++) {
                setCell(r, j, 1);
            }
        } else if (!isHorizontal) {
            for (int i = r; i < (size + r); i++) {
                if (getCell(i, c) == 1) {
                    return "Another ship occupying this space, please redo";
                }
            }
            for (int j = r; j < (size + r); j++) {
                setCell(j, c, 1);
            }
        }


        super.draw(false);
        ships.add(new Ship(r, c, size, isHorizontal, this));        
        size--;
        if (size < 2) {
            acceptClick = false;
        }
        return "Ship of size " + (size +1) + " placed in (" + r + "," + c + ").";
    }
}
