package sbs.spacebattleship;

import java.util.Scanner;

public class Human implements Player {

    private Scanner reader;

    public Human() {
        reader = new Scanner(System.in);
    }

    @Override
    public boolean shoot(Board board) {
        System.out.println("Give coordinate 1");
        int r = reader.nextInt();
        System.out.println("Give coordinate 2");
        int c = reader.nextInt();
        if (board.getCell(r, c) == 1) {
            System.out.println("Hit!");
            board.setCell(r, c, 2);
            return true;
        } else {
            System.out.println("Miss!");
            board.setCell(r, c, 3);
            return false;
        }
    }
}
