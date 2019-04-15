package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实际leetcode runtime Solution比Solution1,Solution2都慢，不知道为什么。
 */
public class IntersectionOfTwoArraysII {

    /**
     * O(n)
     */
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                if (map.containsKey(nums1[i])) {
                    map.put(nums1[i], map.get(nums1[i]) + 1);
                } else {
                    map.put(nums1[i], 1);
                }
            }

            Map<Integer, Integer> map2 = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) {
                if (map2.containsKey(nums2[i])) {
                    map2.put(nums2[i], map2.get(nums2[i]) + 1);
                } else {
                    map2.put(nums2[i], 1);
                }
            }
            List<Integer> list = new ArrayList<>();
            for (Integer key : map2.keySet()) {
                if (map.containsKey(key)) {
                    int tmp = Math.min(map.get(key), map2.get(key));
                    for (int i = 0; i < tmp; i++) {
                        list.add(key);
                    }
                }
            }

            int i = 0;
            int[] rr = new int[list.size()];
            for (Integer num : list) {
                rr[i++] = num;
            }
            return rr;
        }
    }

    /**
     * O(nlogn) 有副作用
     */
    class Solution1 {
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0, j = 0, k = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    nums1[k++] = nums1[i];
                    i++;
                    j++;
                }
            }
            return nums1;
        }
    }
    /**
     * O(nlogn) 无副作用
     */
    class Solution2 {
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0, j = 0;
            ArrayList<Integer> list = new ArrayList<>(Math.min(nums1.length, nums2.length));
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    i++;
                } else if (nums1[i] > nums2[j]) {
                    j++;
                } else {
                    list.add(nums1[i]);
                    i++;
                    j++;
                }
            }
            int[] r = new int[list.size()];
            for (i = 0; i < list.size(); i++) {
                r[i] = list.get(i);
            }
            return r;
        }
    }
}
