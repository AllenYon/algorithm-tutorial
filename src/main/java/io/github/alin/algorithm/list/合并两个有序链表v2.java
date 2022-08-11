package io.github.alin.algorithm.list;

public class 合并两个有序链表v2 {

    public ListNode mergeTowLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTowLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTowLists(list2.next, list1);
            return list2;
        }
    }

}
