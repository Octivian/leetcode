package binarySearch;

public class GuessNumber {
    public static class Solution {
        public static int guessNumber(int n) {
            int min = 1;
            int max = n;
            while (min <= max) {
                int a = (max - min) / 2 + min; //尽量用Naive写法，不用 (max+min)/2 ,避免max+min 越界 int
                int r = guess(a, 6);
                if (r == 0) {
                    return a;
                } else if (r == -1) {
                    max = a - 1;
                } else {
                    min = a + 1;
                }
            }
            return -1;
        }
    }

    /**
     * C++ STL algorithm lower_bound
     */
    public static class Solution1 {
        public static int guessNumber(int n) {
            int left = 1;
            int right = n;
            while (left < right) {
                int mid = (right + left) >>> 1;
                if (guess(mid, 6) == 1) {
                    left = mid + 1;
                } else {
                    if (guess(mid, 6) == 0) {
                        return mid;
                    }
                    right = mid;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.guessNumber(10));
        //        System.out.println((2126753389 + 1063376696));
        //        System.out.println(Integer.MAX_VALUE);
    }

    static int guess(int n, int target) {
        return n == target ? 0 : n < target ? -1 : 1;
    }
}
