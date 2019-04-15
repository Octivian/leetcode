package binarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            for (int i = 0; i < nums1.length; i++) {
                set1.add(nums1[i]);
            }

            for (int i = 0; i < nums2.length; i++) {
                set2.add(nums2[i]);
            }

            Set<Integer> tmp = null;

            if (set1.size() > set2.size()) {
                tmp = set1;
                set1 = set2;
                set2 = tmp;
            }

            int[] r = new int[set1.size()];
            int i = 0;
            for (int num : set1) {
                if (set2.contains(num)) {
                    r[i] = num;
                    i++;
                }
            }
            return Arrays.copyOf(r, i);
        }
    }

    class Solution1 {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();

            for (int i = 0; i < nums1.length; i++) {
                set1.add(nums1[i]);
            }
            Set<Integer> tmp = new HashSet<>();

            //if nums2 is sorted，can do binary search，it's O(logn)
            for (int i = 0; i < nums2.length; i++) {
                if (set1.contains(nums2[i])) {
                    tmp.add(nums2[i]);
                }
            }

            int[] r = new int[tmp.size()];
            int i = 0;
            for (int num : tmp) {
                r[i++] = num;
            }

            return r;
        }
    }

    class Solution2 {
        public int[] intersection(int[] nums1, int[] nums2) {
            //            Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
            //            Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            for (int i = 0; i < nums1.length; i++) {
                set1.add(nums1[i]);
            }

            for (int i = 0; i < nums2.length; i++) {
                set2.add(nums2[i]);
            }

            set1.retainAll(set2);

            int[] r = new int[set1.size()];
            int i = 0;
            for (int num : set1) {
                if (set2.contains(num)) {
                    r[i] = num;
                    i++;
                }
            }
            return Arrays.copyOf(r, i);
        }
    }
}
