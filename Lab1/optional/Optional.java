package optional;

import java.util.Scanner;
import optional.Bfs;

public class Optional {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Introduceti numarul n:");
        int n = scan.nextInt();
        scan.close();

        int[][] M = new int[n][n];
        int E = (int) (Math.random() * (n * (n - 1) / 2) + 1);
        System.out.println("Numar de muchii:" + E + "\n");

        int i = 0;
        while (i < E) {
            int c = (int) (Math.random() * n);
            int l = (int) (Math.random() * n);
            if (l != c)
                if (M[l][c] == 0) {
                    System.out.println("Muchia este: " + l + " " + c + "\n");
                    M[l][c] = 1;
                    M[c][l] = 1;
                    i++;
                }
        }

        for (i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(M[i][j] + " ");
            }
            System.out.println();
        }

        Bfs.bfs(M);
    }
}
