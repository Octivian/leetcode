package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindKClosestElements {
    /**
     * O(nlogn)
     */
    class SolutionNaive {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> integers = Arrays.stream(arr).boxed().collect(Collectors.toList());
            Collections.sort(integers, (a, b) -> Math.abs(a - x) - Math.abs(b - x));
            integers = integers.subList(0, k);
            Collections.sort(integers);
            return integers;
        }
    }

    /**
     * O(n-k)
     */
    class SolutionN {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0;
            int right = arr.length - 1;
            while (right - left >= k) {
                int leftRange = Math.abs(arr[left] - x);
                int rightRange = Math.abs(arr[right] - x);
                if (leftRange > rightRange) {
                    left++;
                } else {
                    right--;
                }
            }
            ArrayList<Integer> r = new ArrayList<>();
            for (int i = left; i <= right; i++) {
                r.add(arr[i]);
            }
            return r;
        }
    }

    /**
     * O(logn+k)
     */
    static class SolutionLogn {
        public static List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0;
            int right = 0;
            if (x <= arr[0]) {
                left = 0;
                right = k - 1;
            } else if (x >= arr[arr.length - 1]) {
                left = arr.length - k;
                right = arr.length - 1;
            } else {
                int index = Arrays.binarySearch(arr, x);
                if (index < 0) {
                    index = -index - 1;
                    //没找到时，index取离x较近的index
                    index = Math.abs(x - arr[index - 1]) <= Math.abs(x - arr[index]) ? index - 1 : index;
                }
                left = index + 1;
                right = index;


                while (right - left < k - 1) {
                    right++;
                    left--;
                    if (right > arr.length - 1) {
                        right = arr.length - 1;
                        left = arr.length - k;
                        break;
                    } else if (left < 0) {
                        left = 0;
                        right = k - 1;
                        break;
                    } else {
                        int leftRange = Math.abs(arr[left] - x);
                        int rightRange = Math.abs(arr[right] - x);
                        if (leftRange <= rightRange) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
            }

            List<Integer> r = new ArrayList<Integer>();
            for (int i = left; i <= right; i++) {
                r.add(arr[i]);
            }
            return r;
        }
    }


    public static void main(String[] args) {
        SolutionLogn.findClosestElements(new int[]{0, 0, 1, 2, 3, 3, 4, 7, 7, 8}, 3, 5).forEach(x -> System.out.println(x));
//        SolutionLogn.findClosestElements(new int[]{0, 1, 1, 1, 2, 3, 6, 7, 8, 9}, 9, 4).forEach(x -> System.out.println(x));
    }
}
