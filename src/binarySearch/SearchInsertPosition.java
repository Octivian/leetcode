package binarySearch;

public class SearchInsertPosition {

    class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    if (nums[mid] == target) {
                        return mid;
                    } else {
                        right = mid;
                    }
                }
            }
            //target 大于所有元素是边界情况
            return nums[left] < target ? left + 1 : left;
        }
    }
}
