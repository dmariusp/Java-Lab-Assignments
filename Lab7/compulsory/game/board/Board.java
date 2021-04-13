package compulsory.game.board;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

/**
 * Board class describes how the tokens are extracted
 */
@Getter
public class Board {
    private List<Token> tokenList = new LinkedList<>();    //all tokens on board
    private int numberAvailableTokens;       //number of available tokens
    private int n;

    public Board(int n, int m) {
        numberAvailableTokens = m;
        createTokens(n);
    }

    /**
     * This function creates tokens (pairs like (i1,i2), i1 != i2) ==> there will be n*n-n tokens
     *
     * @param n
     */
    private void createTokens(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    Pair p = new Pair(i, j);
                    Token t = new Token(p);
                    addToken(t);
                }
            }
        }
        System.out.println(tokenList);
    }

    public void addToken(Token t) {
        tokenList.add(t);
    }

    public Token inspectToken(int index) {
        Token t = tokenList.get(index);

        return t;
    }

    /**
     *
     * @param index index of token
     */
    public synchronized void removeToken(int index) {
        tokenList.get(index).setAvailable(false);
        lessAvailable();
    }

    /**
     * This function verifies if the token of a certain index can be used
     *
     * @param index
     * @return true if a token can be used, false otherwise
     */
    public boolean existToken(int index) {
        if (index >= tokenList.size()) {
            return false;
        } else if (!tokenList.get(index).isAvailable()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * if there are not enough tokens left on the table, a circuit can not be made
     *
     * @return
     */
    public boolean cantMakePairs() {
        if (numberAvailableTokens < tokenList.size() / 2) {
            return true;
        }
        return false;
    }

    public synchronized void lessAvailable() {
        numberAvailableTokens--;
    }

    @Override
    public String toString() {
        return "Board{" +
                "tokenList=" + tokenList +
                ", numberAvailableTokens=" + numberAvailableTokens +
                '}';
    }
}
