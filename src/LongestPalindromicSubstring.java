public class LongestPalindromicSubstring {
    class Solution {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();

            char[] rChars = new char[chars.length];

            char[] r = new char[chars.length];

            for (int i = 0, j = chars.length - 1; i < chars.length; i++, j--) {
                rChars[j] = chars[i];
            }

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == rChars[i]) {
                    r[i] = chars[i];
                } else {

                }
            }
            return "";
        }
    }
}
