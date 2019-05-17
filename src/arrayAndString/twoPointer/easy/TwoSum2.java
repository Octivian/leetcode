package arrayAndString.twoPointer.easy;

public class TwoSum2 {
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            int[] r = new int[2];
            while (numbers[left] + numbers[right] != target) {
                if (numbers[left] + numbers[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
            //+1 for leetcode
            r[0] = left + 1;
            r[1] = right + 1;
            return r;
        }
    }
}
