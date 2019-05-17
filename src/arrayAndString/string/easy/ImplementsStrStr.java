package arrayAndString.string.easy;

public class ImplementsStrStr {
    class Solution {
        public int strStr(String haystack, String needle) {
            char[] a = haystack.toCharArray();
            char[] b = needle.toCharArray();
            int m = a.length;
            int n = b.length;
            if (n == 0) {
                return 0;
            }
            if (n > m) {
                return -1;
            }
            int r = -1;
            int j = 0;
            for (int i = 0; i < m; i++) {
                if (a[i] == b[j]) {
                    if (j == 0) {
                        r = i;
                    }
                    if (j == n - 1) {
                        return r;
                    }
                    j++;
                } else if (r != -1) {
                    j = 0;
                    i = r;
                    r = -1;
                }
            }
            r = j < n ? -1 : r;
            return r;
        }
    }

    class Solution1 {
        public int strStr(String haystack, String needle) {
            for (int i = 0; ; i++) {
                for (int j = 0; ; j++) {
                    if (j == needle.length()) {
                        return i;
                    }
                    if (i + j == haystack.length()) {
                        return -1;
                    }
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * not convert string to array , slower
     */
    class Solution2 {
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {

                return 0;
            }
            if (needle.length() > haystack.length()) {
                return -1;
            }
            int j = 0;
            int r = -1;
            for (int i = 0; i < haystack.length(); i++) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    if (j == 0) {
                        r = i;
                    }
                    if (j == needle.length() - 1) {
                        return r;
                    }
                    j++;
                } else if (r != -1) {
                    j = 0;
                    i = r;
                    r = -1;
                }
            }
            r = j < needle.length() ? -1 : r;
            return r;
        }
    }
}
