package binarySearch;

public class Sqrtx {
    class Solution {
        public int mySqrt(int x) {
            //avoid mid == 0 as Denominator
            if (x == 0 || x == 1) {
                return x;
            }
            int max = x;
            int min = 0;
            int mid = 0;
            while (min <= max) {
                mid = (max - min) / 2 + min; //尽量用Naive写法，不用 (max+min)/2 ,避免max+min 越界 int
                if (mid <= x / mid && mid + 1 > x / (mid + 1)) {
                    return mid;
                } else if (mid < x / mid) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
            return mid;
        }
    }

    /**
     * C++ STL algorithm lower_bound
     */
    class Solution1 {
        public int mySqrt(int x) {
            //避免分母为0
            if (x == 0 || x == 1) {
                return x;
            }
            int left = 0;
            int right = x;
            while (left < right) {
                int mid = (right + left) >>> 1;
                //相除避免Integer越界
                if (mid < x / mid) {
                    if (mid + 1 > x / mid + 1) {
                        return mid;
                    }
                    left = mid + 1;
                } else {
                    if (mid == x / mid) {
                        return mid;
                    }
                    right = mid;
                }
            }
            return right;
        }
    }
}
