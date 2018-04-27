package scrabble;

import java.util.LinkedList;
import java.util.List;

// An instance of this class will hold the list of words submitted by the players
// Make sure that the board is thread-safe
public class Board {
    private List<String> words;

    public Board() {
        this.words = new LinkedList <>();
    }

    public void addWord(Player player, String word){
        this.words.add(word);
        System.out.println( " Player " + player + " submitted the word: " + "\"" + word + "\"");
    }

}
