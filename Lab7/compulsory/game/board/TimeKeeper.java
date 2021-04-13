package compulsory.game.board;

import compulsory.game.Game;
import lombok.Getter;

import java.util.Timer;
import java.util.TimerTask;

/**
 * TimeKeeper class is used to create threads of timeKeeper type to perform concurrently with the players; when the time is over, the game is also be over
 */
@Getter
public class TimeKeeper implements Runnable {
    private int seconds;
    private Timer timer;
    private TimerTask whenEndGame;
    private TimerTask countdown;
    private int countdownSeconds = 10;

    public TimeKeeper(Game game, int sec) {
        if (sec < countdownSeconds) {
            this.seconds = sec + countdownSeconds;
        } else {
            this.seconds = sec;
        }

        timer = new Timer(true);

        /**
         * A task is performed in thread, so after a number of seconds, the game is over
         */
        whenEndGame = new TimerTask() {
            @Override
            public void run() {
                game.endGame();
                System.out.println("End of time!\n ~~GAME OVER!!~~");
            }
        };

        /**
         * Countdown for the task: when the countdown reaches 0, the task above is called
         */
        countdown = new TimerTask() {
            @Override
            public void run() {
                if (countdownSeconds > 0) {
                    countdownSeconds--;
                    System.out.println("\n" + countdownSeconds + " seconds are left!\n ");
                }
            }
        };

    }

    /**
     * Starting the thread
     */
    @Override
    public void run() {
        timer.schedule(whenEndGame, 1000 * seconds);
        timer.scheduleAtFixedRate(countdown, (seconds - countdownSeconds) * 1000, 1000);
    }
}
