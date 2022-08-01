package io.github.alin.algorithm.list;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xn2925/
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 */
public class 删除链表的倒数第N个节点 {



    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        int last = length(head) - n;
        for (int i = 0; i < last - 1; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

}
