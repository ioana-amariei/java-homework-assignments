package game;

import java.util.Timer;
import java.util.TimerTask;

public class Countdown {
    private Timer timer;
    private int countDown;
    private int secondsLeft;

    public Countdown() {
        timer = new Timer();
    }

    public void reset() {
        secondsLeft = countDown;
        // Decrease seconds left every 1 second.
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                --secondsLeft;
                if (secondsLeft == 0) {
                    timer.cancel();
                }
            }
        }, 0, 1000);
    }

    public void setCountDown(int seconds) {
        this.countDown = seconds;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

}
