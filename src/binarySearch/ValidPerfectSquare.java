package binarySearch;

public class ValidPerfectSquare {
    class Solution {
        public boolean isPerfectSquare(int num) {
            int left = 0;
            int right = num + 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (mid < (double) num / mid) {
                    left = mid + 1;
                } else {
                    if (mid == (double) num / mid) {
                        return true;
                    } else {
                        right = mid;
                    }
                }
            }
            return false;
        }
    }
}
