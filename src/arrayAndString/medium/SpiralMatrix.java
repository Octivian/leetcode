package arrayAndString.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> r = new ArrayList<>();
            int m = matrix.length;
            if (m == 0) {
                return r;
            }
            int n = matrix[0].length;

            int x = 0, y = 0;

            //define 4 sides
            int left = 0, right = m - 1;
            int up = 0, down = n - 1;

            for (int i = 0; i < m * n; i++) {
                r.add(matrix[x][y]);
                //point(x,y) 4 situations on 4 sides
                //start from left then down , right , up
                if (x == left && y < down) {
                    y++;
                } else if (y == down && x < right) {
                    x++;
                } else if (x == right && y > up) {
                    y--;
                } else if (y == up && x > left) {
                    x--;
                    //after turned over 4 sides
                    //shrink 4 sides
                    //make new point(x,y) on new left side ,and new up side
                    if (x == left) {
                        left++;
                        right--;
                        up++;
                        down--;
                        x = left;
                        y = up;
                    }
                }
            }
            return r;
        }
    }
}
