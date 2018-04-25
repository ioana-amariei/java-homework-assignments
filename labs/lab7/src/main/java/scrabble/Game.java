package scrabble;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private Bag bag;
    private Board board;
    //private Dictionary dictionary;
    private final List<Player> players = new ArrayList<>();

    public List <Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    //Create the method that will start the game: start one thread for each player
    public void start() {
        System.out.println("START GAME!" + "\n");

        for (Player player : players){
           this.setBag(new Bag());
            player.run();
        }

        System.out.println("\n");
        System.out.println("GAME FINISHED!");
    }

    @Override
    public String toString() {
        return "Game{" +
                "bag=" + bag +
                '}';
    }
}
