package com.xiongzehua.learning.algorithm.nowcoder66;


import java.util.HashMap;

/**
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Created by xiongzehua on 2019/3/4.
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode current = pHead;
        ListNode pre = null;
        ListNode newList = new ListNode(-1); // 空头节点
        ListNode newListCurrent = newList;
        while (current != null) {
            boolean preEquals = pre == null? false : current.val == pre.val;
            boolean nextEquals = current.next == null? false : current.val == current.next.val;
            if (!preEquals && !nextEquals) {
                newListCurrent.next = current;
                newListCurrent = newListCurrent.next;
            }
            pre = current;
            current = current.next;
        }
        newListCurrent.next = null;
        return newList.next;
    }
}

