package com.xiongzehua.learning.algorithm.nowcoder66;

import java.util.HashMap;

/**
 * 两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。
 * Created by xiongzehua on 2019/3/6.
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashMap<ListNode, Boolean> visited = new HashMap<>(32);
        ListNode current1 = pHead1;
        while (current1 != null) {
            visited.put(current1, true);
            current1 = current1.next;
        }
        ListNode current2 = pHead2;
        while (current2 != null) {
            if (visited.get(current2) != null)
                return current2;
            current2 = current2.next;
        }
        return null;
    }
}
