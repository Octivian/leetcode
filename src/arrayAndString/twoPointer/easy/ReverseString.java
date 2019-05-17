package arrayAndString.twoPointer.easy;

public class ReverseString {
    class Solution {
        public void reverseString(char[] s) {
            int min = 0;
            int max = s.length - 1;
            while (min < max) {
                char tmp = s[min];
                s[min] = s[max];
                s[max] = tmp;
                min++;
                max--;
            }
        }
    }
}
