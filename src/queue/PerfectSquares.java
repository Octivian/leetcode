package queue;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquares {

    /**
     * BFS
     */
    static class Solution {
        public static int numSquares(int n) {
            int step = 0;
            Queue<Integer> q = new LinkedList<>();
            q.offer(n);

            while (q.size() != 0) {
                step++;
                int size = q.size();
                for (int j = 0; j < size; j++) {
                    Integer num = q.poll();
                    for (int k = 1; k * k <= num; k++) {
                        if (num == k * k) {
                            return step;
                        } else {
                            q.offer(num - k * k);
                        }
                    }
                }
            }
            return step;
        }
    }

    public static void main(String[] args) {

        System.out.println(Solution.numSquares(7168));
    }
}
