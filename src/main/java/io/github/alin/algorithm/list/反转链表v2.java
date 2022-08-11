package io.github.alin.algorithm.list;

public class 反转链表v2 {


    /**
     * null    1-2-3-4
     * null-1   2-3-4
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }
}
