package stack;

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

    public static void main(String[] args) {
        System.out.println("");
    }
}
