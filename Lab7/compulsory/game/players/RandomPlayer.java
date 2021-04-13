package compulsory.game.players;

import compulsory.game.Game;
import compulsory.game.board.Board;
import compulsory.game.board.Token;

import java.util.Random;

/**
 * same as ManualPlayer class, but the token is randomly chosen
 */
public class RandomPlayer extends Player {
    private Random rnd;


    public RandomPlayer(int id, String name, Game g) {
        super(id, name, g);
        rnd = new Random();
    }

    @Override
    protected void chooseToken(Board board) {
        int ok = 0;
        do {
            System.out.println("\nI choose from board next token: ");
            int choice = rnd.nextInt(game.getRange());    //choose index random from 0....last index available

            if (board.existToken(choice)) {
                Token currentToken = board.inspectToken(choice);
                System.out.println(currentToken);
                if (tokenList.size() >= 1) {
                    ok = usedList(board, ok, choice, currentToken);
                } else {
                    ok = 1;
                    board.removeToken(choice);
                    addToList(currentToken);
                    computeScore("no");

                }
            } else {
                System.out.println("Token not available, choose another one");
            }

            if (ok == 1) {
                if (choice == game.getRange() - 1) {
                    game.setRange(choice);
                }
            }
        } while (ok == 0);
    }

    private int usedList(Board board, int ok, int choice, Token currentToken) {
        Token lastToken = tokenList.get(tokenList.size() - 1);
        if (lastToken.getPair().getPoz2() == currentToken.getPair().getPoz1()) {
            ok = 1;
            if (tokenList.get(circuitStartIndex).getPair().getPoz1() == currentToken.getPair().getPoz2()) {
                closeCircuit();
            } else {
                computeScore("no");
            }
            board.removeToken(choice);
            addToList(currentToken);
        } else {
            if (board.cantMakePairs() || madeCircuit) {
                madeCircuit = false;
                ok = 1;
                board.removeToken(choice);
                addToList(currentToken);
                computeScore("no");
            } else {
                System.out.println("\nYou did not choose a token in order to create a circuit");
            }
        }
        return ok;
    }
}
