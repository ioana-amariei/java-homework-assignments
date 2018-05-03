package scrabble;

public class TimeKeeper implements Runnable{
    private long startTime;

    public TimeKeeper() {
        startTime = System.currentTimeMillis();
    }

    private float getElapsedTimeSeconds() {
        return (System.currentTimeMillis() - startTime) / 1000f;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("\n Time elapsed in seconds: " + getElapsedTimeSeconds());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
