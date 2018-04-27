package scrabble;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class EnglishDictionary implements Dictionary {
    private List <String> dictionary;

    public EnglishDictionary() {
        this.dictionary = new LinkedList <>();

        String fileName = "acceptable-words.txt";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                dictionary.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "EnglishDictionary{" +
                "dictionary=" + dictionary +
                '}';
    }

    @Override
    public boolean containsWord(String word) {
        return dictionary.contains(word);
    }
}
