package arrayAndString.string.medium;

public class ReverseWordsInAString {
    static class Solution {
        public static String reverseWords(String s) {
            String[] split = s.trim().split(" ");
            if (split.length == 0) {
                return s;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = split.length - 1; i > 0; i--) {
                if (!split[i].isEmpty()) {
                    sb.append(split[i]).append(" ");
                }
            }
            sb.append(split[0]);
            return sb.toString();
        }
    }
}
