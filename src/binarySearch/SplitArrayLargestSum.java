package binarySearch;

public class SplitArrayLargestSum {
    class Solution {
        public int splitArray(int[] nums, int m) {
            int min = 0;
            for (int num : nums) {
                min = Math.max(min, num);
            }

            int max = 0;
            for (int i = m - 1; i < nums.length; i++) {
                max += nums[i];
            }

            //  lower bound definitely equals the largest sum of m subarrays
            while (min < max) {
                int mid = (min + max) >>> 1;
                System.out.println(min + ":" + mid + ":" + max);
                if (valid(nums, mid, m)) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            return min;
        }

        private boolean valid(int[] a, int target, int m) {
            int total = 0;
            int cnt = 1;
            for (int num : a) {
                total += num;
                if (total > target) {
                    total = num;
                    if (++cnt > m) {
                        //target not enough big, too many sum(subarray) bigger than target
                        return false;
                    }
                }
            }
            //means target too big, sum(subarray)'s count <= m , target should decrease
            return true;
        }
    }
}
