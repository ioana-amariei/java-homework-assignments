import scrabble.*;

import java.util.TimerTask;


public class Application {
    public static void main(String args[]) {
        Game game = new Game();

        game.setBag(new Bag());
        game.setBoard(new Board());
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));

        game.start();
    }
}
