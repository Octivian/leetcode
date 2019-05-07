package arrayAndString.easy;

public class LargestNumberAtLeastTwiceOfOthers {
    class Solution {
        public int dominantIndex(int[] nums) {
            int max = 0;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            int index = -1;
            for (int i = 0; i < nums.length; i++) {
                if (max == nums[i]) {
                    index = i;
                }
                if (max != nums[i] && max / 2d < nums[i]) {
                    return -1;
                }
            }
            return index;
        }
    }
}
