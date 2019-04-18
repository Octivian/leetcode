package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> charMap = new HashMap<>();
            charMap.put('{', '}');
            charMap.put('[', ']');
            charMap.put('(', ')');
            char[] charArray = s.toCharArray();

            if (charArray.length == 0) {
                return true;
            }

            if (charArray.length % 2 == 1 || charMap.values().contains(charArray[0])) {
                return false;
            }

            Stack<Character> chars = new Stack<>();

            for (char cha : charArray) {
                if (cha == '{' || cha == '[' || cha == '(') {
                    chars.push(cha);
                } else {
                    char c = chars.peek();
                    if (charMap.get(c) == cha) {
                        chars.pop();
                    } else {
                        return false;
                    }
                }
            }
            return chars.empty() ? true : false;
        }
    }

    class Solution1 {
        public boolean isValid(String s) {
            Map<Character, Character> charMap = new HashMap<>();
            charMap.put('{', '}');
            charMap.put('[', ']');
            charMap.put('(', ')');
            char[] charArray = s.toCharArray();

            Stack<Character> chars = new Stack<>();

            for (char cha : charArray) {
                if (charMap.containsKey(cha)) {
                    chars.push(cha);
                } else {
                    if (chars.empty() || charMap.get(chars.peek()) != cha) {
                        return false;
                    }
                    chars.pop();
                }
            }
            return chars.empty() ? true : false;
        }
    }
}
