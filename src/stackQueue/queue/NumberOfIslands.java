package stackQueue.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfIslands {
    class Solution {

        public int numIslands(char[][] grid) {
            int num = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        BFS(grid, i, j);
                        num++;
                    }
                }
            }
            return num;
        }

        public void BFS(char[][] grid, int x, int y) {
            int num = 0;
            int h = grid.length;
            int v = grid[0].length;

            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            q.offer(x * v + y);
            visited.add(x * v + y);

            while (q.size() != 0) {
                int size = q.size();
                for (int k = 0; k < size; k++) {
                    Integer peek = q.peek();
                    q.remove();

                    int i = peek / v;
                    int j = peek % v;

                    grid[i][j] = 0;

                    int rightChildCode = (i + 1) * v + j;
                    int leftChildCode = (i - 1) * v + j;
                    int downChildCode = i * v + j + 1;
                    int upChildCode = i * v + j - 1;

                    if (i + 1 < h && !visited.contains(rightChildCode) && grid[i + 1][j] == '1') {

                        q.offer(rightChildCode);
                        visited.add(rightChildCode);
                    }
                    if (i - 1 >= 0 && !visited.contains(leftChildCode) && grid[i - 1][j] == '1') {

                        q.offer(leftChildCode);
                        visited.add(leftChildCode);
                    }
                    if (j + 1 < v && !visited.contains(downChildCode) && grid[i][j + 1] == '1') {
                        q.offer(downChildCode);
                        visited.add(downChildCode);
                    }
                    if (j - 1 >= 0 && !visited.contains(upChildCode) && grid[i][j - 1] == '1') {
                        q.offer(upChildCode);
                        visited.add(upChildCode);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid =
            new char[][] {
                //                {'1', '1', '1', '1', '0'},
                //                {'1', '1', '0', '1', '0'},
                //                {'1', '1', '0', '0', '0'},
                //                {'0', '0', '0', '0', '0'},

                {'1'}, {'0'}, {'1'}, {'0'}, {'1'}, {'1'}
            };
        //        Solution.numIslands(grid);
    }
}
