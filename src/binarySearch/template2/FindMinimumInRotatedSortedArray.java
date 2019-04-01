package binarySearch.template2;

public class FindMinimumInRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[0] <= nums[mid] && nums[mid] > nums[nums.length - 1]) {
                    left = mid + 1;
                } else if (nums[0] > nums[mid] && nums[mid] <= nums[nums.length - 1]) {
                    right = mid;
                } else {
                    return nums[0];
                }
            }
            return nums[right];
        }
    }
}
