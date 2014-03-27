package sbs.spacebattleship;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Game game = new Game(10, 3);
        game.drawBoard(true);
        game.play();

    }
}
