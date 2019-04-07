package binarySearch;

public class Power {
    class Solution {
        public double myPow(double x, int n) {
            if (n == 0)
                return 1;
            long realN = Math.abs((long) n);
            double r = 1d;
            for (long i = realN; i > 0; i >>= 1) {
                if ((i & 1) == 1)
                    r *= x;
                x *= x;
            }
            if (n < 0)
                r = 1 / r;
            return r;

        }
    }

    class SolutionRecursive {
        public double myPow(double x, int n) {
            if (n > 0) {
                return pow(x, n);
            } else {
                return 1 / pow(x, -n);
            }

        }

        private double pow(double x, int n) {
            if (n == 0)
                return 1;
            double r = pow(x, n >>> 1);
            if ((n & 1) == 1) {
                return r * r * x;
            } else {
                return r * r;
            }
        }
    }

}
