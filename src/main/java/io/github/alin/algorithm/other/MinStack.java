package io.github.alin.algorithm.other;

import java.util.Stack;

public class MinStack {

    public class StackNode {
        int val;
        int min;

        public StackNode(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Stack<StackNode> stack = new Stack<>();

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new StackNode(val, val));
        } else {
            int min = Math.min(val, getMin());
            stack.push(new StackNode(val, min));
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.peek().val;
        }
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            return stack.peek().min;
        }
    }
}
