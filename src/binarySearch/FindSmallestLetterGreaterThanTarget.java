package binarySearch;

public class FindSmallestLetterGreaterThanTarget {
    /**
     * 基本就是求upper_bound问题
     */
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            int left = 0;
            int right = letters.length - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (letters[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return letters[left] <= target ? letters[0] : letters[left];
        }
    }
}
