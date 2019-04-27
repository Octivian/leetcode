package stackQueue.queue;

import java.util.Stack;

class MyCircularQueue {

    private final int[] queue;

    private int head = 0;
    private int tail = -1;

    private int num = 0;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int size) {
        queue = new int[size];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            tail = (tail + 1) % queue.length;
            queue[tail] = value;
            num++;
            return true;
        }
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            head = (head + 1) % queue.length;
            num--;
            return true;
        }
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[tail];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return num == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return num == queue.length;
    }
}

/**
 * push O(n) pop O(1)
 */
class MyQueueUsingStack {
    /**
     * Initialize your data structure here.
     */
    Stack<Integer> s1;

    Stack<Integer> s2;

    public MyQueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {

        return s1.isEmpty() ? 0 : s1.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {

        return s1.isEmpty() ? 0 : s1.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.isEmpty();
    }
}

/**
 * push O(1) pop O(1)
 */
class MyQueueUsingStack1 {

    /**
     * Initialize your data structure here.
     */
    Stack<Integer> s1;

    Stack<Integer> s2;

    public MyQueueUsingStack1() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        s1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s1.isEmpty() && s2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj = new MyQueue(); obj.push(x); int param_2 =
 * obj.pop(); int param_3 = obj.peek(); boolean param_4 = obj.empty();
 */
