package compulsory.game.board;

import lombok.Getter;

@Getter
public class Pair {
    private int poz1;
    private int poz2;

    public Pair(int p1, int p2){
        this.poz1 = p1;
        this.poz2 = p2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "poz1=" + poz1 +
                ", poz2=" + poz2 +
                '}';
    }
}
