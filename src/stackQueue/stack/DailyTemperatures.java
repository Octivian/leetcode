package stackQueue.stack;

import java.util.Stack;

public class DailyTemperatures {
    class SolutionStack1 {
        public int[] dailyTemperatures(int[] T) {
            Stack<Entry> s = new Stack<>();
            int[] r = new int[T.length];
            s.push(new Entry(0, T[0]));
            for (int i = 1; i < T.length; i++) {

                if (T[i] > s.peek().val) {
                    while (!s.empty()) {
                        if (T[i] <= s.peek().val) {
                            break;
                        }
                        Entry pop = s.pop();
                        r[pop.index] = i - pop.index;
                    }
                }
                s.push(new Entry(i, T[i]));
            }
            return r;
        }
    }

    /**
     * stupid , just push index into stackQueue.stack
     */
    class Entry {
        int index;
        int val;

        Entry(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }

    /**
     * no Entry, push index into stackQueue.stack
     */
    class Solution2 {
        public int[] dailyTemperatures(int[] T) {
            int[] ans = new int[T.length];
            Stack<Integer> stack = new Stack();
            stack.push(0);
            for (int i = 1; i < T.length; i++) {
                if (T[i] > T[stack.peek()]) {
                    while (!stack.isEmpty()) {
                        int peek = stack.peek();
                        if (T[i] <= T[peek]) {
                            break;
                        }
                        ans[peek] = i - peek;
                        stack.pop();
                    }
                }
                stack.push(i);
            }
            return ans;
        }
    }

    /**
     * reverse into stackQueue.stack,hold biggest element in stackQueue.stack , pop smaller
     */
    class Solution3 {
        public int[] dailyTemperatures(int[] T) {
            int[] ans = new int[T.length];
            Stack<Integer> s = new Stack();
            for (int i = T.length - 1; i >= 0; --i) {
                while (!s.isEmpty() && T[i] >= T[s.peek()]) {
                    s.pop();
                }
                ans[i] = s.isEmpty() ? 0 : s.peek() - i;
                s.push(i);
            }
            return ans;
        }
    }
}
