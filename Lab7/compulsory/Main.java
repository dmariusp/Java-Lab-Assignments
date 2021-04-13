package compulsory;

import compulsory.game.Game;
import compulsory.game.players.ManualPlayer;
import compulsory.game.players.Player;
import compulsory.game.players.RandomPlayer;

public class Main {
    public static void main(String[] args) {
        Game newGame = new Game(10, 50);    //only 50 tokens will be on board
        System.out.println("New game!\n Your task is: choose a token from table (a pair (i1,i2)).\nYour next move must be like (i2, i3).");
        System.out.println("You have to make close pairs, so the i1 from your first token must be the same with i3 from your last move. If there are tokens left on the table, then you can choose another one.");
        System.out.println("\nGood luck! May the Force be with you!");
        newGame.addPlayer(new RandomPlayer(1, "Marius", newGame));
        newGame.addPlayer(new RandomPlayer(2, "Tudor", newGame));
        newGame.addPlayer(new RandomPlayer(3, "Izidora", newGame));
        newGame.addPlayer(new RandomPlayer(4, "Stefana", newGame));

        newGame.startGame();

        while (newGame.isPlaying()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
