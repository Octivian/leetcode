package arrayAndString.twoPointer.easy;

import java.util.Arrays;

public class ArrayPartition1 {
    class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int r = 0;
            for (int i = 0; i < nums.length; i = i + 2) {
                r += nums[i];
            }
            return r;
        }
    }
}
