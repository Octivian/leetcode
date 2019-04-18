package stack;

import java.util.Stack;

public class MyStack {
    Stack<Integer> s = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        if (x <= min) {
            s.push(min);
            min = x;
        }
        s.push(x);
    }

    public void pop() {
        int e = s.pop();
        if (e == min) {
            min = s.pop();
        }
    }

    public Integer top() {
        return s.peek();
    }

    public Integer getMin() {
        return min;
    }
}
