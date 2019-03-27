import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MedianOfTwoSortedArrays {

    /**
     * O(m+n)
     */
    class Solution1 {
        public  double findMedianSortedArrays(int[] nums1, int[] nums2) {


            int i=0;
            int j=0;

            int length = nums1.length+nums2.length;
            int[] allNums = new int[length];

            int x=0;

            while(i<nums1.length && j<nums2.length){


                if (nums1[i]<=nums2[j]){
                    allNums[x++]=nums1[i++];
                }else{
                    allNums[x++]=nums2[j++];
                }
            }

            while(i<nums1.length){
                allNums[x++]=nums1[i++];
            }
            while(j<nums2.length){
                allNums[x++]=nums2[j++];
            }


            return length%2==0?(allNums[length/2]+allNums[length/2-1])/2d:allNums[length/2];
        }
    }
}
