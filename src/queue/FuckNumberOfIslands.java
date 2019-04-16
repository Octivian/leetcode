package queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FuckNumberOfIslands {
    class Solution {

        public int numIslands(char[][] grid) {
            return 0;
        }

        public void BFS(char[][] grid, int x, int y) {
            int num = 0;
            int h = grid.length;
            int v = grid[0].length;

            Queue<Integer> q = new LinkedList<Integer>();
            Set<Integer> visited = new HashSet<>();

            q.offer(x * h + y);
            visited.add(x * h + y);


            while (q.size() != 0) {
                int size = q.size();
                for (int k = 0; k < size; k++) {
                    Integer peek = q.peek();
                    q.remove();

                    int i = peek % h;
                    int j = peek / h;

                    if (i + 1 < h) {
                        grid[i + 1][j] = 0;
                    }
                    if (j + 1 < v) {
                        grid[i][j + 1] = 0;
                    }
                }
            }
        }
    }
}
