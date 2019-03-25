import java.util.HashMap;

public class TwoSum {
    /**
     * Naive Solution
     *
     * <p>Time complexity O(N^2)
     */
    class SolutionNormal {
        public int[] twoSum(int[] nums, int target) {
            int[] a = new int[2];
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        a[0] = i;
                        a[1] = j;
                    }
                }
            }
            return a;
        }
    }

    /**
     * Use HashMap Solution
     *
     * <p>Time complexity O(N)
     */
    class SolutionHashTable {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                int a = target - nums[i];
                if (hashMap.containsKey(a)) {
                    result[0] = hashMap.get(a);
                    result[1] = i;
                    return result;
                }
                hashMap.put(nums[i], i);
            }
            return result;
        }
    }
}
