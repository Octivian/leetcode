package binarySearch;

public class BinarySearch {
    class Solution {
        public int search(int[] nums, int target) {
            int min = 0;
            int max = nums.length - 1;

            while (min < max || min == max) {
                int mid = (max - min) / 2 + min; //尽量用Naive写法，不用 (max+min)/2 ,避免max+min 越界 int
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }
            return -1;
        }
    }
}
