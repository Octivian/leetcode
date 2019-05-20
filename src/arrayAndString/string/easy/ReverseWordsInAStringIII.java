package arrayAndString.string.easy;

public class ReverseWordsInAStringIII {
    class Solution {
        public String reverseWords(String s) {
            String[] split = s.split(" ");
            StringBuilder r = new StringBuilder();
            for (int i = 0; i < split.length - 1; i++) {
                r.append(new StringBuilder(split[i]).reverse()).append(" ");
            }
            r.append(new StringBuilder(split[split.length - 1]).reverse());
            return r.toString();
        }
    }
}
