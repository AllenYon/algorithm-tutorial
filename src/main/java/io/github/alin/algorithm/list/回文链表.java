package io.github.alin.algorithm.list;

import java.util.Stack;

public class 回文链表 {

    public boolean isPalindrome(ListNode head) {

        ListNode node = head;
        Stack<Integer> stack = new Stack<>();

        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }

        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }

        return true;
    }
}
