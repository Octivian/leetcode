package stack;

public class NumberOfIslands {
    class Solution {
        public int numIslands(char[][] grid) {
            int num = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        num++;
                        DFS(grid, i, j);
                    }
                }
            }
            return num;
        }

        private void DFS(char[][] grid, int i, int j) {

            if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
                grid[i][j] = '0';
                DFS(grid, i + 1, j);
                DFS(grid, i, j + 1);
                DFS(grid, i - 1, j);
                DFS(grid, i, j - 1);
            }
        }
    }
}
