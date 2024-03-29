package scrabble;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private final List <Player> players = new ArrayList <>();
    private Dictionary dictionary;
    private Bag bag;
    private Board board;

    public Game() {
        this.dictionary = new EnglishDictionary();
    }

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
        System.out.println("Initial bag size: " + this.getBag().getLetters().size());

        for (Player player : players) {
            new Thread(player).start();
        }
    }

    public void displayCurrentTime() {
        Thread thread = new Thread(new TimeKeeper());
        thread.setDaemon(true);
        thread.start();
    }

    public boolean finished() {
        return bag.getLetters().isEmpty() || players.size() > 26;
    }

    @Override
    public String toString() {
        return "Game{" +
                "bag=" + bag +
                '}';
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

}
