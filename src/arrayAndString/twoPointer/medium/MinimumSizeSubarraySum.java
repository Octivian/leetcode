package arrayAndString.twoPointer.medium;

public class MinimumSizeSubarraySum {
    class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int r = 0;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                int j = i;
                for (; j < nums.length && sum < s; j++) {
                    sum += nums[j];
                }
                if (sum >= s) {
                    r = r == 0 ? j - i : Math.min(r, j - i);
                }
            }
            return r;
        }
    }

    class Solution1 {
        public int minSubArrayLen(int s, int[] nums) {
            int r = Integer.MAX_VALUE;
            int sum = 0;
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                while (sum >= s) {
                    r = Math.min(r, i - j + 1);
                    sum -= nums[j++];
                }
            }
            return r == Integer.MAX_VALUE ? 0 : r;
        }
    }
}
