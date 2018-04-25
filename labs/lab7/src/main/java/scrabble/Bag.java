package scrabble;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


//An instance of this class will hold all the available letters.
public class Bag {
    private final Queue <Character> letters = new LinkedList <>();

    public Bag() {
        // Add all the letters from 'a' to 'z' in the bag.
        String alphabet = "abcdefeghjiklmnopqrstuvwxyz";

        for (int i = 0; i < alphabet.length(); i++) {
            letters.add(alphabet.charAt(i));
        }
    }

    public Queue <Character> getLetters() {
        return letters;
    }

    public synchronized List <Character> extractLetters(int howMany) {
        List <Character> extracted = new ArrayList <>();

        for (int i = 0; i < howMany; i++) {
            if (letters.isEmpty()) break;
            extracted.add(letters.poll());
        }

        return extracted;
    }

    @Override
    public String toString() {
        return "Bag{" +
                "letters=" + letters +
                '}';
    }
}
