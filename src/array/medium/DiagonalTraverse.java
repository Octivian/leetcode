package array.medium;

public class DiagonalTraverse {
    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {

            int m = matrix.length;
            if (m == 0) {
                return new int[] {};
            }
            int n = matrix[0].length;
            int[] ints = new int[m * n];
            int index = 0;
            boolean up = false;

            //every loop is a slash direction , x + y = code , code start from 0 to (m-1)+(n-1)
            for (int code = 0, x = 0; code <= ((m - 1) + (n - 1)); code++) {
                //determine every slash loop's start x index
                int i = x;
                // 2 situiations , up and down, up or down make sure not out of boundry m and n;
                while ((!up && i >= 0 && code - i < n) || (up && i < m && code - i >= 0)) {
                    ints[index++] = matrix[i][code - i];
                    //up means to right and up
                    //down means to left and down
                    i = up ? i + 1 : i - 1;
                }

                x = up ? Math.min(i, m - 1) : (code - i < n) ? 0 : i + 2;
                up = up ? false : true;
            }

            return ints;
        }
    }
}
