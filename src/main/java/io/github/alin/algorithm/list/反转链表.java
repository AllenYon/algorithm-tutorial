package io.github.alin.algorithm.list;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnnhm6/
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class 反转链表 {

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }

        ListNode node = stack.pop();
        ListNode dummy = node;
        while (!stack.isEmpty()) {
            ListNode tmp = stack.pop();
            node.next = tmp;
            node = node.next;
        }
        node.next = null;
        return dummy;
    }
}
