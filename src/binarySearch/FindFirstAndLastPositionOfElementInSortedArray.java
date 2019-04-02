package binarySearch;

public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * C++ STL lower_bound upper_bound
     */
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[] {-1, -1};
            }
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int index1 = -1;
            if (nums[right] != target) {
                return new int[] {-1, -1};
            } else {
                index1 = right;
            }

            left = index1;
            right = nums.length; //upper_bound的right = nums.length
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return new int[] {index1, right - 1}; //upper_bound的结果 为 x>value 的下界，所以要减一 ，x<=value的上界
        }
    }
}
