package binarySearch.template3;

public class FindFirstAndLastPositionOfElementInSortedArray {

    class Solution1 {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[] {-1, -1};
            }
            int left = 0;
            int right = nums.length - 1;
            while (left + 1 < right) {
                int mid = (right + left) >>> 1;
                if (target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            int index1 = -1;
            if (nums[left] == target) {
                index1 = left;
            } else if (nums[right] == target) {
                index1 = right;
            } else {
                return new int[] {-1, -1};
            }

            left = index1;
            right = nums.length - 1;
            while (left + 1 < right) {
                int mid = (right + left) >>> 1;
                if (nums[mid] <= target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            int index2 = -1;
            if (nums[right] == target) {
                index2 = right;
            } else if (nums[left] == target) {
                index2 = left;
            }

            return new int[] {index1, index2};
        }
    }

    //    class Solution2 {
    //        public int[] searchRange(int[] nums, int target) {
    //            if (nums == null || nums.length == 0) {
    //                return new int[] {-1, -1};
    //            }
    //            int start = findIndex(nums,target,true);
    //            if(start)
    //
    //        }
    //    }
    //
    //    private int findIndex(int[] nums, int target, boolean isLeft) {
    //        int left = 0;
    //        int right=nums.length-1;
    //        while (left + 1 < right) {
    //            int mid = (left + right) >>> 1;
    //            if (nums[mid] > target || (isLeft && nums[mid] == target)) {
    //                right = mid;
    //            } else {
    //                left = mid;
    //            }
    //        }
    //        return left;
    //    }
}
