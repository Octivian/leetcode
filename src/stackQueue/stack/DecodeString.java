package stackQueue.stack;

import java.util.Stack;

public class DecodeString {
    /**
     * There are more effecient solution,but this is easy to understand
     */
    class Solution {
        public String decodeString(String s) {
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == ']') {

                    String sub = "";
                    String subR = "";
                    while (Character.isLetter(stack.peek())) {
                        sub = stack.pop() + sub;
                    }

                    stack.pop();
                    String num = "";
                    while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                        num = stack.pop() + num;
                    }

                    for (int j = 0; j < Integer.parseInt(num); j++) {
                        subR += sub;
                    }

                    for (int j = 0; j < subR.toCharArray().length; j++) {
                        stack.push(subR.toCharArray()[j]);
                    }
                } else {
                    stack.push(chars[i]);
                }
            }
            String r = "";
            while (!stack.isEmpty()) {
                r = stack.pop() + r;
            }
            return r;
        }
    }

    /**
     * most efficient solution, more easy to understand
     */
    class Solution1 {
        public String decodeString(String s) {
            Stack<String> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();

            int count = 0;
            String str = "";
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                } else if (s.charAt(i) == '[') {
                    s2.push(count);
                    count = 0;
                    s1.push(str);
                    str = "";
                } else if (s.charAt(i) == ']') {
                    StringBuilder sb = new StringBuilder(s1.pop());
                    Integer pop = s2.pop();
                    for (int j = 0; j < pop; j++) {
                        sb.append(str);
                    }
                    str = sb.toString();

                } else {
                    str += s.charAt(i) + "";
                }
            }
            return str;
        }
    }

    public static void main(String[] args) {
        System.out.println("");
    }
}
