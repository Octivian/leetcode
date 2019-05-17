package arrayAndString.string.easy;

public class AddBinary {
    class Solution {
        public String addBinary(String a, String b) {

            if (a.length() < b.length()) {
                String tmp = a;
                a = b;
                b = tmp;
            }
            int m = a.length();
            int n = b.length();
            char[] nums = new char[m];
            int beyond = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = m - 1; i >= 0; i--) {
                int j = i - (m - n);
                int num;
                if (j < 0) {
                    num = Character.getNumericValue(a.charAt(i)) + beyond;
                } else {
                    num = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(j)) + beyond;
                }
                nums[i] = (char) (num % 2 + '0');
                beyond = num > 1 ? 1 : 0;
            }
            if (beyond == 1) {
                sb.append("1");
            }
            sb.append(nums);
            return sb.toString();
        }
    }

    class Solution1 {
        public String addBinary(String a, String b) {

            StringBuilder sb = new StringBuilder();
            int i = a.length() - 1, j = b.length() - 1, beyond = 0;
            while (i >= 0 || j >= 0) {
                int num = beyond;
                if (i >= 0) {
                    num += (int) a.charAt(i--) - '0'; // remeber char to int do -'0'
                }
                if (j >= 0) {
                    num += (int) b.charAt(j--) - '0';
                }
                System.out.println(num);
                sb.append(num % 2);
                beyond = num / 2;
            }
            if (beyond == 1) {
                sb.append("1");
            }
            return sb.reverse().toString();
        }
    }
}
