import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    class SolutionSlidingWindow {
        public int lengthOfLongestSubstring(String s) {
            String curString = "";
            int length = s.length();
            int i = 0, j = 0, sum = 0;
            while (j < length) {
                char ch = s.charAt(j);
                if (curString.contains(String.valueOf(ch))) {
                    sum = Math.max(sum, curString.length());
                    i = curString.indexOf(ch) + i + 1;
                }
                curString = s.substring(i, ++j);
            }
            return Math.max(sum, curString.length());
        }
    }

    class SolutionSlidingWindowOptimized {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int length = s.length(), sum = 0;
            for (int i = 0, l = 0; i < length; ) {
                if (map.containsKey(s.charAt(i))) {
                    //重复的char，比上一次出现的重复char更低位，重置低位游标时取较大值
                    l = Math.max(l, map.remove(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                sum = Math.max(sum, ++i - l);
            }
            return sum;
        }
    }
}
