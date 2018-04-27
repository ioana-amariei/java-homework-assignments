package scrabble;


public class Result implements Runnable {
    private Game game;

    public Result(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
        game.displayResults();
    }
}
