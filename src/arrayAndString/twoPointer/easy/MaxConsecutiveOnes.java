package arrayAndString.twoPointer.easy;

public class MaxConsecutiveOnes {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int r1 = 0, r2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    r1++;
                } else {
                    r2 = Math.max(r2, r1);
                    r1 = 0;
                }
            }
            return Math.max(r1, r2); //for only one element
        }
    }
}
