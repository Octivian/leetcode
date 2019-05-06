package binarySearch;

public class MedianOfTwoSortedArrays {

    /**
     * O(m+n)
     */
    class Solution1 {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int i = 0;
            int j = 0;

            int length = nums1.length + nums2.length;
            int[] allNums = new int[length];

            int x = 0;

            while (i < nums1.length && j < nums2.length) {

                if (nums1[i] <= nums2[j]) {
                    allNums[x++] = nums1[i++];
                } else {
                    allNums[x++] = nums2[j++];
                }
            }

            while (i < nums1.length) {
                allNums[x++] = nums1[i++];
            }
            while (j < nums2.length) {
                allNums[x++] = nums2[j++];
            }

            return length % 2 == 0 ? (allNums[length / 2] + allNums[length / 2 - 1]) / 2d : allNums[length / 2];
        }
    }

    /**
     * O(log(min(m,n)))
     */
    class SolutionBinarySearch {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;

            if (m > n) {
                int tmp = m;
                m = n;
                n = tmp;

                int[] tmpNums = nums1;
                nums1 = nums2;
                nums2 = tmpNums;
            }

            if (m == 0) {
                return n % 2 == 1 ? nums2[n / 2] : (nums2[n / 2 - 1] + nums2[n / 2]) / 2d;
            }

            int min = 0, max = m;

            int maxLeft = 0, minRight = 0;

            int mid = (m + n) / 2; // m+n即总长度为奇数时，mid偏小，例如 3.5实际得3

            while (min < max || min == max) { // min等于max的时候也要算啊！
                int i = (max + min) / 2;
                int j = mid - i; // m+n即总长度为奇数时，由于mid偏小 ，j也偏小，所以整体左半边数组长度，比右半边数组长度小一，最后中位数取minRight;

                // 由于i+j总是等于数组总长度的一半，所以随i变大或变小，j则变小或变大 ，如果nums1.length>nums2.length，所以i的活动范围比j大，那么j就可能越界，所以开头要判断数组大小
                if (i > 0 && nums1[i - 1] > nums2[j]) {
                    max = i - 1;
                } else if (i < m && nums1[i] < nums2[j - 1]) {
                    min = i + 1;
                } else {
                    // i j 不可能同时为0
                    if (i == 0) {
                        maxLeft = nums2[j - 1];
                    } else if (j == 0) {
                        maxLeft = nums1[i - 1];
                    } else {
                        maxLeft = Math.max(nums2[j - 1], nums1[i - 1]);
                    }

                    //i j 不可能同时为对应数组的长度
                    if (i == m) {
                        minRight = nums2[j];
                    } else if (j == n) {
                        minRight = nums1[i];
                    } else {
                        minRight = Math.min(nums2[j], nums1[i]);
                    }
                    break;
                }
            }

            return (m + n) % 2 == 0 ? (minRight + maxLeft) / 2d : minRight;
        }
    }

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int m = nums1.length;
            int n = nums2.length;

            if (m > n) {
                int tmp = m;
                m = n;
                n = tmp;

                int[] tmpNums = nums1;
                nums1 = nums2;
                nums2 = tmpNums;
            }

            if (m == 0) {
                return n % 2 == 1 ? nums2[(n >>> 1)] : (nums2[(n >>> 1) - 1] + nums2[n >>> 1]) / 2d;
            }

            int left = 0;

            int right = nums1.length;

            int leftMax = 0;

            int rightMin = 0;

            while (left <= right) {
                int mid1 = (left + right) >>> 1;
                int mid2 = ((m + n) >>> 1) - mid1;

                if (mid1 > 0 && nums1[mid1 - 1] > nums2[mid2]) { //mid左移
                    right = mid1 - 1;
                } else if (mid1 < m && nums2[mid2 - 1] > nums1[mid1]) { //mid右移
                    left = mid1 + 1;
                } else { //  leftMax<=rightMin
                    if (mid1 == 0) {
                        leftMax = nums2[mid2 - 1];
                        //两种情况，1：nums1,nums2平分，也就是元素数目相等，nums2，完全在左，rigntMin就为nums1[0] ,2：nums2右端和nums1有重合，比较取最小
                        rightMin = mid2 == n ? nums1[0] : Math.min(nums1[mid1], nums2[mid2]);
                    } else if (mid1 == m) {
                        //两张情况，同上
                        leftMax = mid2 == 0 ? nums1[mid1 - 1] : Math.max(nums1[mid1 - 1], nums2[mid2 - 1]);
                        rightMin = nums2[mid2];
                    } else {
                        leftMax = Math.max(nums1[mid1 - 1], nums2[mid2 - 1]);
                        rightMin = Math.min(nums1[mid1], nums2[mid2]);
                    }

                    break;
                }
            }

            return (m + n) % 2 == 0 ? (leftMax + rightMin) / 2d : rightMin;
        }
    }
}
