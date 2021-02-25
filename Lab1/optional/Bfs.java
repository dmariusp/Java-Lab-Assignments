package optional;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    /**
     * bfs function: traverses the graph and verifies if it is connected, either way it displays the connected components
     *
     * @param M - matrix which will be used for furthermore operations
     */
    public static void bfs(int[][] M) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int n = M.length;
        int ok = 0;
        int[] visited = new int[n];
        int x = 0;
        int i = 0;
        while (i < n) {
            int nr = 0;
            LinkedList<Integer> connectedComponents = new LinkedList<Integer>();
            if (visited[i] == 0) {
                queue.add(i);
                nr++;
                connectedComponents.add(i);
                visited[i] = 1;
                while (queue.size() != 0) {
                    int nod = queue.poll();
                    for (int j = 1; j < n; j++) {
                        if (M[nod][j] == 1 && visited[j] == 0) {
                            queue.add(j);
                            nr++;
                            connectedComponents.add(j);
                            visited[j] = 1;
                        }
                    }
                }
                if(nr == n)
                    printConnectedComponents(true,connectedComponents);
                else
                    printConnectedComponents(false,connectedComponents);
            }
            i++;
        }

    }

    public static void printConnectedComponents(boolean connected,LinkedList<Integer> connectedComponents){
        if(connected) {
            System.out.println("Graf conex :)");
            System.out.print(connectedComponents);
        }
        else {
            System.out.println("\nMai multe componente conexe");
            System.out.print(connectedComponents);
        }
    }
}
