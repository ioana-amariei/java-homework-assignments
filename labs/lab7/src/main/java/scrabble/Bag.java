package scrabble;

import java.util.*;

// Source: http://www.java2s.com/Code/Java/Development-Class/generatestringconsistsofrandomcharacters.htm
//An instance of this class will hold all the available letters.
public class Bag {
    private final Queue <Character> letters = new LinkedList <>();

    public Bag() {
        String alphabet = "  aaaaaaaaabbccddddeeeeeeeeeeeeffggghhiiiiiiiiijkllllmmnnnnnnooooooooppqrrrrrrssssttttttuuuuvvwwxyyz";
//        String alphabet = "  abcdefghhijklmnopqrstuvwxyz";

        Random random = new Random();

        for (int i = 0; i < alphabet.length(); i++) {
            letters.add(alphabet.charAt(random.nextInt(alphabet.length())));
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
        return "letters=" + letters +
                '}';
    }
}
