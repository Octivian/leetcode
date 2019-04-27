package stackQueue.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStackUsingQueue {
    /**
     * one queue , push O(1) pop O(n)
     */
    class MyStack {

        /**
         * Initialize your data structure here.
         */
        Queue<Integer> q;

        public MyStack() {
            q = new LinkedList<>();
        }

        /**
         * Push element x onto stackQueue.stack.
         */
        public void push(int x) {
            q.offer(x);
        }

        /**
         * Removes the element on top of the stackQueue.stack and returns that element.
         */
        public int pop() {
            for (int i = 0; i < q.size() - 1; i++) {
                q.offer(q.poll());
            }
            return q.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            for (int i = 0; i < q.size() - 1; i++) {
                q.offer(q.poll());
            }
            int r = q.poll();
            q.offer(r);
            return r;
        }

        /**
         * Returns whether the stackQueue.stack is empty.
         */
        public boolean empty() {
            return q.isEmpty();
        }
    }

    /**
     * one queue, push O(n) , pop O(1)
     */
    class MyStack1 {

        /**
         * Initialize your data structure here.
         */
        Queue<Integer> q;

        public MyStack1() {
            q = new LinkedList<>();
        }

        /**
         * Push element x onto stackQueue.stack.
         */
        public void push(int x) {
            q.offer(x);
            for (int i = 0; i < q.size() - 1; i++) {
                q.offer(q.poll());
            }
        }

        /**
         * Removes the element on top of the stackQueue.stack and returns that element.
         */
        public int pop() {
            return q.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return q.peek();
        }

        /**
         * Returns whether the stackQueue.stack is empty.
         */
        public boolean empty() {
            return q.isEmpty();
        }
    }
}
