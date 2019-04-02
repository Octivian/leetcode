package binarySearch;

public class SearchInRotatedSortedArray {
    static class Solution {
        public static int search(int[] nums, int target) {
            int min = 0;
            int max = nums.length - 1;
            while (min <= max) {
                int mid = (max - min) / 2 + min;
                if (nums[mid] == target) {
                    return mid;
                }
                //是真正的Rotated,mid在左半边，左半边可能只有一个元素，所以nums[min] <= nums[mid]
                if (nums[min] <= nums[mid] && nums[mid] > nums[max]) {
                    //target在[min,mid) 等于min的时候当然也要算了，不然窗口移动就出错了
                    if (nums[min] <= target && target < nums[mid]) {
                        if (nums[min] == target) {
                            return min;
                        }
                        max = mid - 1;
                    } else { // target在(mid,max]
                        min = mid + 1;
                    }

                } else if (nums[min] > nums[mid] && nums[mid] <= nums[max]) {
                    if (nums[mid] < target && target <= nums[max]) {
                        if (nums[max] == target) {
                            return max;
                        }
                        min = mid + 1;
                    } else {
                        max = mid - 1;
                    }
                } else { //完全正序
                    if (target > nums[mid]) {
                        min = mid + 1;
                    } else {
                        max = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

    /**
     * C++ STL algorithm lower_bound
     */
    class Solution1 {
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] < target) {
                    if (nums[mid] < nums[0] && target > nums[nums.length - 1]) { //nums[mid]和target分跨两边
                        right = mid;
                    } else { //正常情况
                        left = mid + 1;
                    }
                } else {
                    if (nums[mid] == target) {
                        return mid;
                    } else {
                        if (target < nums[0] && nums[mid] > nums[nums.length - 1]) { //nums[mid]和target分跨两边
                            left = mid + 1;
                        } else { //正常情况
                            right = mid;
                        }
                    }
                }
            }
            return nums[left] == target ? left : -1;
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 3};
        System.out.println(Solution.search(a, 5));
    }
}
