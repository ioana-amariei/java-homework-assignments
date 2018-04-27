package scrabble;


public class Result implements Runnable {
    private Game game;

    public Result(Game game) {
        this.game = game;
    }

    private void display() {
        System.out.println("Results:");
        for (Player player : game.getPlayers()) {
            System.out.println("Player: " + player.getName() + " obtained: " + player.getScore() + " points.");
        }
    }

    @Override
    public void run() {
        display();
    }
}
