package compulsory.game.players;

import compulsory.game.Game;
import compulsory.game.board.Board;
import compulsory.game.board.Token;

import java.util.Scanner;

public class ManualPlayer extends Player {
    private Scanner in = new Scanner(System.in);

    public ManualPlayer(int id, String name, Game g) {
        super(id, name, g);
    }

    /**
     * Implementation of the chooseToken method from abstract class Player.
     * If it's the first move, the player can add any kind of token but if not, then their next token's first index in pair must be the same as the last token added, like their last index in pair.
     * If the tokens matches and, in addition, the last index of the current pair is the same as the index of the circuit's start, that means he has made a circuit.
     * <p>
     * If the player has made a circuit, he can chose whichever token available from the table
     * <p>
     * In addition, if there are no more tokens left on the table, so that all together can make a circuit, then every player can choose any token
     * because game is over when there are no tokens left on the table
     *
     * @param board
     */
    @Override
    protected void chooseToken(Board board) {
        System.out.println(board.getTokenList());
        int ok = 0;      //checks if the token picked is a good one
        do {
            System.out.println("Choose from board next token: ");
            int choice = in.nextInt() - 1;     //extracts index     1----n (transform in 1---n-1

            if (board.existToken(choice)) {   //if the chosen index is good
                Token currentToken = board.inspectToken(choice);
                System.out.println(currentToken);
                if (tokenList.size() >= 1) {
                    ok = usedList(board, ok, choice, currentToken);
                } else {
                    ok = 1;                     //if it's the first move
                    board.removeToken(choice);
                    addToList(currentToken);
                    computeScore("no");
                }
            } else {
                System.out.println("Token not available, choose another one");
            }
        } while (ok == 0);
    }

    /**
     * This method is called only if tokens are already added in tokenList
     * in order to see if it's good for making circuits
     *
     * @param board        the board from where we extract tokens
     * @param ok           parameter for verifications in case of success when choosing a token
     * @param choice       the index of the token we interrogate
     * @param currentToken the current token that is extracted
     * @return ok
     */
    private int usedList(Board board, int ok, int choice, Token currentToken) {
        Token lastToken = tokenList.get(tokenList.size() - 1);
        if (lastToken.getPair().getPoz2() == currentToken.getPair().getPoz1()) {     //(i1,i2) ~ (i2,i3)
            ok = 1;
            if (tokenList.get(circuitStartIndex).getPair().getPoz1() == currentToken.getPair().getPoz2()) {
                closeCircuit();                       //(i1,i2) ~ (i2, i3) ~ .. ~ (ik,i1)
            } else {
                computeScore("no");            //bonus was not received
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
                System.out.println("You did not choose a token in order to create a circuit");
            }
        }
        return ok;
    }
}
