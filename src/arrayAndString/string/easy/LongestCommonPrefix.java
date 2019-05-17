package arrayAndString.string.easy;

public class LongestCommonPrefix {
    /**
     * vertical scanning
     */
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String base = "";
            for (int i = 0; strs.length > 0 && i <= strs[0].length(); i++) {
                for (int j = 1; j < strs.length; j++) {
                    if (i > strs[j].length() || !strs[0].substring(0, i).equals(strs[j].substring(0, i))) {
                        return base;
                    }
                }
                base = strs[0].substring(0, i);
            }
            return base;
        }
    }

    /**
     * horizon scanning
     */
    class Solution1 {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            String r = strs[0];
            for (int i = 1; i < strs.length; i++) {
                while (strs[i].indexOf(r) != 0) {
                    r = r.substring(0, r.length() - 1);
                    if (r.isEmpty()) {
                        return "";
                    }
                }
            }
            return r;
        }
    }
}
