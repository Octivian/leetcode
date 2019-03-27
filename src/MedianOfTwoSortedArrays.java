import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] left, right;

            int[] leftNums1 = Arrays.copyOfRange(nums1, 0, nums1.length / 2 + 1);
            int[] leftNums2 = Arrays.copyOfRange(nums2, 0, nums2.length / 2 + 1);

            int[] rightNums1 = Arrays.copyOfRange(nums1, nums1.length / 2 + 1, nums1.length);
            int[] rightNums2 = Arrays.copyOfRange(nums2, nums1.length / 2 + 1, nums2.length);

            return 0d;
        }
    }
}
