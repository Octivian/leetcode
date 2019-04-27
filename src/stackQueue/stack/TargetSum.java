package stackQueue.stack;

public class TargetSum {
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            return DFS(nums, 0, 0, S);
        }

        private int DFS(int[] nums, int index, int cur, int S) {
            if (index == nums.length) {
                if (cur == S) {
                    return 1;
                } else {
                    return 0;
                }
            }

            return DFS(nums, index + 1, cur + nums[index], S) + DFS(nums, index + 1, cur - nums[index], S);
        }
    }
}
