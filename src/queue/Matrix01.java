package queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
    /**
     * BFS
     */
    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            int[][] r = new int[matrix.length][matrix[0].length];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        r[i][j] = 0;
                    } else {
                        r[i][j] = BFS(matrix, i, j);
                    }
                }
            }
            return r;
        }

        int BFS(int[][] matrix, int x, int y) {

            Queue<Integer> q = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();
            int v = matrix[0].length;
            int code = x * v + y;
            int step = 0;
            q.add(code);
            visited.add(code);

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = q.poll();

                    x = poll / v;
                    y = poll % v;

                    if (matrix[x][y] == 0) {
                        return step;
                    } else {
                        int upCode = x * v + y - 1;
                        if (y - 1 >= 0 && !visited.contains(upCode)) {
                            q.offer(upCode);
                            visited.add(upCode);
                        }

                        int downCode = x * v + y + 1;
                        if (y + 1 < matrix[0].length && !visited.contains(downCode)) {
                            q.offer(downCode);
                            visited.add(downCode);
                        }
                        int leftCode = (x - 1) * v + y;
                        if (x - 1 >= 0 && !visited.contains(leftCode)) {
                            q.offer(leftCode);
                            visited.add(leftCode);
                        }
                        int rightCode = (x + 1) * v + y;
                        if (x + 1 < matrix.length && !visited.contains(rightCode)) {
                            q.offer(rightCode);
                            visited.add(rightCode);
                        }
                    }
                }
                step++;
            }
            return -1;
        }
    }
}
