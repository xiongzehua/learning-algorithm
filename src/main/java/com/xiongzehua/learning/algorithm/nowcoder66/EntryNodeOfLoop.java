package com.xiongzehua.learning.algorithm.nowcoder66;

import java.util.HashMap;

/**
 * 链表中环的入口结点
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Created by xiongzehua on 2019/3/9.
 */
public class EntryNodeOfLoop {
    private ListNode first;
    private HashMap visit = new HashMap();
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        try {
            dfs(pHead);
        } catch (Exception e) {

        }
        return first;
    }

    private void dfs(ListNode node) {
         if (node != null) {

             if (visit.get(node) == null) {
                 visit.put(node, true);
             }
             else {
                 first = node;
                 throw new RuntimeException("有换了");
             }

             dfs(node.next);
         }
    }
}
