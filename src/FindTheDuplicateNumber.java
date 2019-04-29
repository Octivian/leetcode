import java.util.HashSet;
import java.util.Set;

public class FindTheDuplicateNumber {
    /**
     * time O(n) , space O(n)
     */
    class Solution {
        public int findDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return nums[i];
                } else {
                    set.add(nums[i]);
                }
            }
            return -1;
        }
    }

    /**
     * fatest solution , awesome
     */
    class Solution1 {
        public int findDuplicate(int[] nums) {
            int[] r = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                if (++r[nums[i]] > 1) {
                    return nums[i];
                }
            }
            return -1;
        }
    }

    /**
     * 龟兔赛跑，判断链表有环
     */
    class Solution2 {
        public int findDuplicate(int[] nums) {
            int t = nums[0];
            int r = nums[0];

            do {
                t = nums[t]; //龟一次走一步
                r = nums[nums[r]]; //兔一次走两步
            } while (t != r);

            //TODO
            return t;
        }
    }
}
