
package sbs.spacebattleship;

public class Game {
    
   private Board board;
   
   public Game()  {
       board = new Board(10, 10);
   }  
   
   public void initBoard() {
       
   }
   
   public void drawBoard() {
       board.draw();
   }
}
