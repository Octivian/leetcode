package array.easy;

public class FindPivotIndex {
    class Solution {
        public int pivotIndex(int[] nums) {
            int total = 0;
            for (int num : nums) {
                total += num;
            }
            int left = 0;
            for (int i = 0; i < nums.length; i++) {
                left += i - 1 < 0 ? 0 : nums[i - 1];
                int pivot = nums[i];
                int right = total - (left + pivot);
                if (right == left) {
                    return i;
                }
            }
            return -1;
        }
    }
}
