package scrabble;

public class Result {
    private Game game;

    public Result(Game game) {
        this.game = game;
    }

    public void display() {
        System.out.println("\n Results:");

        for (Player player : game.getPlayers()) {
            System.out.println("Player: " + player.getName() + " obtained: " + player.getScore() + " points.");
        }
    }
}
