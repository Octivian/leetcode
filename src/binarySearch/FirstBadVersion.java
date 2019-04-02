package binarySearch;

/**
 * 无限逼近 这特么就是标准的 C++ STL lower_bound
 */
public class FirstBadVersion {
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = (right + left) >>> 1;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    static boolean isBadVersion(int n) {
        return n > 38 - 1;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(100));
    }
}
