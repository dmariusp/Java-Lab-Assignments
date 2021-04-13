package compulsory.game.board;


import lombok.Getter;
import lombok.Setter;

import java.util.Random;

/**
 * Token class which describes how will the token be like
 */
@Getter
@Setter
public class Token {
    private int value;       //random value
    private Pair pair;       //pair of (i1,i2) like elements
    private boolean isAvailable = true;    //after one player picks a certain token, it is no longer available for the others

    public Token(Pair p) {
        Random rnd = new Random();
        value = rnd.nextInt(100);
        this.pair = p;
    }

    @Override
    public String toString() {
        return "Token{" +
                "value=" + value +
                ", pair=" + pair +
                '}';
    }
}
