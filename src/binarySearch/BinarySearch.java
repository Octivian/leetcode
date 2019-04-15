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

    /**
     * C++ STL algorithm lower_bound
     */
    class Solution1 {
        public int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length;
            while (left < right) {
                int mid = (right + left) >>> 1;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    if (nums[mid] == target) {
                        return mid;
                    }
                    right = mid;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
