package arrayAndString.easy;

public class PlusOne {
    class Solution {
        public int[] plusOne(int[] digits) {

            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            int beyond = 0;
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i] = digits[i] + beyond;
                if (digits[i] >= 10) {
                    digits[i] = digits[i] % 10;
                    beyond = 1;
                } else {
                    beyond = 0;
                }
            }
            if (beyond == 1) {
                int[] r = new int[digits.length + 1];
                r[0] = 1;
                for (int i = 0; i < digits.length; i++) {
                    r[i + 1] = digits[i];
                }
                return r;
            }
            return digits;
        }
    }

    class Solution1 {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            return ints;
        }
    }
}
