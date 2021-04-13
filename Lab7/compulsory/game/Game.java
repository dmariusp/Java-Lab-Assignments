package compulsory.game;

import compulsory.game.board.Board;
import compulsory.game.board.TimeKeeper;
import compulsory.game.players.Player;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Game class, in which game logic is implemented
 */

@Getter
public class Game {
    private int n;        //the last type of token
    private int m;        //number of tokens on board
    private boolean playing = false;
    private Board b;
    private List<Player> playerList = new ArrayList<>();   //here we add the players
    private List<Thread> threads = new ArrayList<>();     //here we add the threads
    private int currentPlayer;         //will be the index of current player in playerList
    private TimeKeeper timeKeeper;
    private int range;                 //the range in which randomPlayer will search for token indexes

    public Game(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public void setRange(int range) {
        this.range = range;
    }

    /**
     * Method which creates the board, the threads, and maintains the threads order
     */
    public synchronized void startGame() {
        b = new Board(n, m);
        playing = true;
        range = n * n - n;

        for (Player player : playerList) {
            Thread playerThread = new Thread(player);
            threads.add(playerThread);
            playerThread.start();
        }

        currentPlayer = 0;
        timeKeeper = new TimeKeeper(this, 10);   //time thread
        Thread timerThread = new Thread(timeKeeper);
        timerThread.setDaemon(true);
        timerThread.start();

    }

    public void addPlayer(Player p) {
        playerList.add(p);
    }

    public Player thisPlayer() {
        return playerList.get(currentPlayer);
    }

    /**
     * every player, will call this method after their turn to pass the tour to next player
     *
     * @return
     */
    public Player nextPlayer() {
        currentPlayer = (++currentPlayer) % playerList.size();
        return playerList.get(currentPlayer);
    }

    /**
     * this method is synchronized to notify all threads and players that the game is over
     */
    public synchronized void endGame() {
        if (playing) {
            playing = false;
            setWinner();
        }
    }

    /**
     *  calculates the winner (best score)
     */
    private void setWinner() {
        int maxScore = 0;
        Player bestPlayer = null;
        for (Player player : playerList) {
            if (maxScore < player.getScore()) {
                maxScore = player.getScore();
                bestPlayer = player;
            }
        }
        System.out.println("\n~~GAME OVER~~\n");
        System.out.println("Winner is: " + bestPlayer + " with score = " + maxScore);
    }

    @Override
    public String toString() {
        return "Game{" +
                "playing=" + playing +
                ", b=" + b +
                ", threads=" + threads +
                '}';
    }
}
