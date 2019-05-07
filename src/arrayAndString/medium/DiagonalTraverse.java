package arrayAndString.medium;

public class DiagonalTraverse {
    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {

            int m = matrix.length;
            if (m == 0) {
                return new int[] {};
            }
            int n = matrix[0].length;
            int[] ints = new int[m * n];
            int code = 0;
            boolean up = true;
            int index = 0;
            int x = 0;
            while (code <= ((m - 1) + (n - 1))) {
                int i = x;
                for (; i >= 0 && code - i < n; ) {
                    ints[index++] = matrix[i][code - i];
                    i = up ? i + 1 : i - 1;
                }
                x = up ? Math.min(i, m - 1) : Math.max(i, 0);
                code++;
            }

            return ints;
        }
    }
}
