package binarySearch;

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

    /**
     * C++ STL lower_bound
     */
    class Solution1 {
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[0] <= nums[mid] && nums[mid] <= nums[nums.length - 1]) {
                    return nums[0];
                } else if (nums[mid] >= nums[0] && nums[mid] > nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left];
        }
    }

    /**
     * lower_bound more simple version
     */
    class Solution2 {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] > nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return nums[left];
        }
    }
}
