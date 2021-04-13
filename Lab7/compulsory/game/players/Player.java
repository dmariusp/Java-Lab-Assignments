package compulsory.game.players;

import compulsory.game.Game;
import compulsory.game.board.Board;
import compulsory.game.board.Token;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * Abstract class player in which the logic of player's turns is implemented
 */

@Getter
@Setter
public abstract class Player implements Runnable {
    protected int id;
    protected String name;
    protected List<Token> tokenList = new LinkedList<>();
    protected Game game;
    protected final int WAIT_TURN = 20;

    protected abstract void chooseToken(Board board);   //will be overridden by all inherited classes

    protected int score = 0;
    protected boolean madeCircuit = false;
    protected int circuitStartIndex = 0;

    public Player(int id, String name, Game g) {
        this.id = id;
        this.name = name;
        this.game = g;
    }

    public void addToList(Token t) {
        tokenList.add(t);
    }

    /**
     * abstract method overridden by the inherited classes in which the logic of choosing a token from the board is implemented
     *
     * @throws InterruptedException it is thrown by sleep when the game is over and the thread must be killed
     */
    private void myTurn() throws InterruptedException {
        System.out.println("\nMy turn " + id);
        chooseToken(game.getB());

        if (game.getB().getNumberAvailableTokens() == 0) {
            game.endGame();
        }
        Thread.sleep(WAIT_TURN);

    }

    /**
     * the main method, overridden from Runnable interface, it is called when the thread is created
     */
    @Override
    public void run() {
        synchronized (game) {
            try {
                while (game.isPlaying()) {
                    while (game.thisPlayer() != this) {
                        game.wait();   //waits his turn
                    }

                    if (game.isPlaying()) {
                        myTurn();   //chooses token
                        System.out.println(id + " finished a tour! Next to enter!");
                    }

                    game.nextPlayer();  //finds next player
                    game.notifyAll();   //notifies when current player ends his turn, so that the other players will wake up from wait
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * this method is used in inherited classes, but it's still available for all classes in order to set the score
     *
     * @param bonus     type of bonus - if the player has made a circuit of length n, he will get double score, if it's a simple one, he will gen only 50 points, otherwise he will not get any bonus
     */
    protected void computeScore(String bonus) {
        score = score + tokenList.get(tokenList.size() - 1).getValue();

        if (bonus.equals("double")) {
            score = 2 * score;
        } else if (bonus.equals("normal")) {
            score = score + 50;
        }
    }

    /**
     * when a player has made a circuit, the boolean parameter is set true; the index of the next circuit is set starting from the next index in tokenList
     */
    protected void closeCircuit() {
        if (tokenList.size() - circuitStartIndex + 1 == game.getN()) {
            System.out.println("\nNoice :> You made a perfect circuit!\n");
            computeScore("double");
        } else {
            System.out.println("\nYou have made a new circuit!\n");
            computeScore("normal");
        }
        madeCircuit = true;
        circuitStartIndex = tokenList.size();
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tokenList=" + tokenList +
                '}';
    }
}

