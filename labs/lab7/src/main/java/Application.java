import scrabble.*;

public class Application {
    public static void main(String args[]) {
        TimeKeeper time = new TimeKeeper();
        new Thread(time).start();

        Game game = new Game();

        game.setBag(new Bag());
        game.setBoard(new Board());
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.addPlayer(new Player("Player 3"));

        game.start();

        Result result = new Result(game);
        if(game.finished()) {
            new Thread(result).start();
        }
    }
}
