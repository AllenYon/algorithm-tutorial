package io.github.alin.algorithm.list;

/**
 * https://leetcode.cn/leetbook/read/top-interview-questions-easy/xnnbp2/
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class 合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode current = result;
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        current.next = list1 == null ? list2 : list1;
        return result.next;
    }
}
