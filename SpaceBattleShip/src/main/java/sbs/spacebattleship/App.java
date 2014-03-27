package sbs.spacebattleship;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Welcome to SpaceBattleShip!");
        Game game = new Game(10, 3);
        game.play();

    }
}
