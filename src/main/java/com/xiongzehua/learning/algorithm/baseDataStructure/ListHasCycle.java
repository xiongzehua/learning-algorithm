package com.xiongzehua.learning.algorithm.baseDataStructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xiongzehua on 2019/3/4.
 */
public class ListHasCycle {
    private HashMap<ListNode, Boolean> visited = new HashMap();
    private ListNode firstNode = null;
    public ListNode entryNodeOfLoop(ListNode pHead) {
        dfs(pHead);
        return firstNode;
    }

    private void dfs(ListNode node) {
        if (node != null) {
            if (visited.get(node) == null) {
                visited.put(node, true);
            } else {
                firstNode = node;
                return;
            }
            dfs(node.next);
        }
    }
}
