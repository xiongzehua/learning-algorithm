package com.xiongzehua.learning.algorithm.nowcoder66;

import java.util.LinkedList;

/**
 * Created by xiongzehua on 2019/3/4.
 */
public class TestCase {
    public static ListNode list1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        return node1;
    }

    public static ListNode list2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        return node1;
    }

    public static void showList(ListNode list) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ListNode current = list;
        while (current != null) {
            linkedList.add(current.val);
            current = current.next;
        }

        System.out.println(linkedList);
    }
}
