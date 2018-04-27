package scrabble;

import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;

public class Player implements Runnable {
    private String name;
    private Game game;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private boolean createSubmitWord() throws InterruptedException {
        List <Character> extracted = game.getBag().extractLetters(1);

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

    @Override
    public void run() {
//        try {
//            while(createSubmitWord()) {
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // initially, each player receives 7 random tiles
        List <Character> extracted = new LinkedList <>();
        extractCharacters(game, extracted, 7);


        while (!game.finished()) {
            game.displayCurrentTime();

            System.out.println(this + " extracted: " + extracted.size() + " tiles: " + extracted);
            List <String> words = determineAcceptableWords(extracted);
            System.out.println("List of possible words for player:" + this.getName() + " : " + words + "\n");

            if (words.isEmpty()) {
                extractCharacters(game, extracted, 1);
            } else {
                String word = words.get(words.size() - 1);

                submitWord(word);
                setScore(computeScore(word));
                removeFromExtracted(extracted, word);

                // After submitting a word of length k, the player will
                // immediately receive another k tiles from the bag (if this is possible)
                int wordLength = word.length();
                if (canExtractTiles(wordLength)) {
                    extractCharacters(game, extracted, wordLength);
                } else {
                    int bagSize = game.getBag().getLetters().size();
                    extractCharacters(game, extracted, bagSize);
                }
            }
        }

        game.displayResults();
    }

    private void removeFromExtracted(List <Character> extracted, String word) {
        for (Character c : word.toCharArray()) {
            extracted.remove(c);
        }
    }

    private void extractCharacters(Game game, List <Character> extracted, int howMany) {
        List <Character> characterList = game.getBag().extractLetters(howMany);
        extracted.addAll(characterList);
    }

    private boolean canExtractTiles(int wordSize) {
        return game.getBag().getLetters().size() >= wordSize;
    }

    private void submitWord(String word) {
        game.getBoard().addWord(this, word);
    }

    private int computeScore(String word) {
        int score = 0;

        String zeroPoints = " ";
        String onePoint = "eaionrtlsu";
        String twoPoints = "dg";
        String threePoints = "bcmp";
        String fourPoints = "fhvwy";
        String fivePoints = "k";
        String eightPoints = "jx";
        String tenPoints = "qz";

        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            String character = c.toString();

            if (zeroPoints.contains(character)) {
                score += 0;
            } else if (onePoint.contains(character)) {
                score += 1;
            } else if (twoPoints.contains(character)) {
                score += 2;
            } else if (threePoints.contains(character)) {
                score += 3;
            } else if (fourPoints.contains(character)) {
                score += 4;
            } else if (fivePoints.contains(character)) {
                score += 5;
            } else if (eightPoints.contains(character)) {
                score += 8;
            } else if (tenPoints.contains(character)) {
                score += 10;
            }
        }

        return score;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", score=" + score;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List <String> determineAcceptableWords(List <Character> extractedLetters) {
        List <String> combinations = generateCombinations(extractedLetters);
        List <String> acceptableWords = new LinkedList <>();

        for (String possibleWord : combinations) {
            if (game.getDictionary().containsWord(possibleWord)) {
                acceptableWords.add(possibleWord);
            }
        }

        return acceptableWords;
    }

    private List <String> generateCombinations(List <Character> extractedLetters) {
        List <String> combinations = new LinkedList <>();

        for (int i = 1; i <= extractedLetters.size(); i++) {
            generateCombinations(extractedLetters, i, 0, new StringBuilder(i), combinations);
        }

        return combinations;
    }

    private void generateCombinations(List <Character> letters, int length, int currentLength, StringBuilder word, List <String> combinations) {
        if (currentLength == length) {
            if(!combinations.contains(word.toString())) {
                combinations.add(word.toString());
            }
        } else if (currentLength < length) {
            for (Character c : letters) {
                StringBuilder stringBuilder = new StringBuilder(word.toString());
                stringBuilder.append(c);

                List <Character> remainingLetters = new LinkedList <>(letters);
                remainingLetters.remove(c);
                generateCombinations(remainingLetters, length, currentLength + 1, stringBuilder, combinations);
            }
        }
    }

    public String getName() {
        return name;
    }
}
