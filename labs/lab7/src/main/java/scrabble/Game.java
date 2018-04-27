package scrabble;

import java.util.ArrayList;
import java.util.List;


public class Game {
    private Dictionary dictionary;
    private final List <Player> players = new ArrayList <>();
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
        for (Player player : players) {
            new Thread(player).start();
        }
    }

    public void displayCurrentTime(){
        // display game time
        TimeKeeper stopwatch = new TimeKeeper();
        stopwatch.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Time elapsed in seconds: " + stopwatch.getElapsedTimeSeconds() + "\n");
    }


    public void displayResults(){
        try {
            Thread.sleep(2000);
            System.out.println("\n Results:");

            for(Player player : players){
                System.out.println("Player: " + player.getName() + " obtained: "  + player.getScore() + " points.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean finished(){
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
