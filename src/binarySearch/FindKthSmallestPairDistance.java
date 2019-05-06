package binarySearch;

import java.util.Arrays;

public class FindKthSmallestPairDistance {
    class Solution {
        public int smallestDistancePair(int[] nums, int k) {
            Arrays.sort(nums);
            int min = nums[1] - nums[0];
            for (int i = 1; i < nums.length - 1; i++) {
                min = Math.min(min, nums[i + 1] - nums[i]);
            }
            int max = nums[nums.length - 1] - nums[0];

            while (min < max) {
                int mid = (min + max) >>> 1;
                //find first dis's  paris counts  >= k , the dis is answer
                if (countPairLessThanOrEqualsDis(nums, mid) < k) {
                    min = mid + 1;
                } else {
                    max = mid;
                }
            }
            return min;
        }

        private int countPairLessThanOrEqualsDis(int[] a, int dis) {
            int r = 0;
            for (int i = 0; i < a.length; i++) {
                r += upperBound(a, i, a.length, a[i] + dis) - i;
            }
            return r;
        }

        //find last index <= target
        private int upperBound(int[] a, int left, int right, int target) {
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (a[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return right - 1;
        }
    }
}
