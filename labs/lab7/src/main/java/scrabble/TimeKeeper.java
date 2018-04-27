package scrabble;

public class TimeKeeper extends Thread{
    private long startTime;

    public TimeKeeper() {
        startTime = System.currentTimeMillis();
        setDaemon(true);
    }

    public float getElapsedTimeSeconds() {
        return (System.currentTimeMillis() - startTime) / 1000f;
    }

}
