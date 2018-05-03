package game;

import java.util.Random;

public class GuessingGame {
    private String player;
    private int max;
    private int attempts;
    private int numberToGuess;
    private int countdown;

    public GuessingGame(String player, int max) {
        this.player = player;
        this.max = max;
        Random random = new Random();
        this.numberToGuess = random.nextInt(max) + 1;
        this.attempts = 0;
    }

    @Override
    public String toString() {
        return "GuessingGame{" +
                "player='" + player + '\'' +
                ", max=" + max +
                ", attempts=" + attempts +
                ", numberToGuess=" + numberToGuess +
                ", countdown=" + countdown +
                '}';
    }

    private long startTime() {
        return System.currentTimeMillis();
    }

    private int seconds(long startTime) {
        long currentTime = System.currentTimeMillis();
        return (int) ((currentTime - startTime) / 1000);
    }

    public String submit(Integer guess) {
        attempts++;

        if (guess > numberToGuess) {
            System.out.println("Number to guess: " + numberToGuess);
            return "Too big!";
        } else if (guess < numberToGuess) {
            System.out.println("Number to guess: " + numberToGuess);
            return "Too small!";
        } else {
            System.out.println("Number to guess: " + numberToGuess);
            return "You got it! Attempts: " + attempts;
        }
    }
}
