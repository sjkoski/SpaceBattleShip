package sbs.gamelogic;

public class Human  {

    public Human() {
    }

    public String shoot(Board board, int r, int c) {
        if (board.getCell(r, c) == 2 || board.getCell(r, c) == 3) {
            return "We have already shelled this location";
        } else if (board.getCell(r, c) == 1) {            
            board.setCell(r, c, 2);
            return "We launch proton torpedoes at (" + r + " , " + c +")! Hit!";
        } else {
            board.setCell(r, c, 3);
            return "We launch proton torpedoes at (" + r + " , " + c +")! Miss!";
        }
    }

}
