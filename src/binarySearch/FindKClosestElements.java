package binarySearch;

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
}
