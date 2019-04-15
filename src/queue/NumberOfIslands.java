package queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            int num = 0;
            int h = grid.length;
            int v = grid[0].length;
            Queue q = new LinkedList<Integer>();
            int i = 0, j = 0;
            q.offer(grid[i][j]);
            q.offer(grid);
            while (q.size() != 0) {
                if (++i < h) {
                    q.offer(i);
                }
            }
            return 0;
        }
    }
}
