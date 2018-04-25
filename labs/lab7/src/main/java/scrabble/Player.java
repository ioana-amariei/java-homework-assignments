package scrabble;

import java.util.List;

public class Player implements Runnable{
    private String name;
    private Game game;
    private boolean available = false;

    public Player(String name) {
        this.name = name;
    }

    private boolean createSubmitWord() throws InterruptedException {
        List<Character> extracted = game.getBag().extractLetters(1);
        if (extracted.isEmpty()) {
            return false;
        }

        StringBuilder word = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            word.append(extracted.get(0));
        }

        game.getBoard().addWord(this, word.toString());
        Thread.sleep(300);
        return true;
    }

    /**
     * In the run method the player will repeatedly extract one letter from the bag,
     * generate a string containing that letter duplicated 10 times and add it on the board.
     * For example, if it extracts the letter 'a', it will add to the board the word 'aaaaaaaaaa'.
     *
     * implement the run() method, that will repeatedly create and submit words
     */
    @Override
    public void run() {
        try {
            while(createSubmitWord()){

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", game=" + game +
                '}';
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
