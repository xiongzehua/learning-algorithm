package com.xiongzehua.learning.algorithm.nowcoder66;

import java.util.LinkedList;

/**
 * 二叉搜索树的第k个结点
 * https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Created by xiongzehua on 2019/3/4.
 */
public class KthNode {
    LinkedList<TreeNode> queue = new LinkedList<>();
    public TreeNode KthNode(TreeNode pRoot, int k) {
        dfs(pRoot);
        TreeNode node = null;
        try {
            node = queue.get(k - 1);
        } catch (Exception e) {

        }
        return node;
    }

    private void dfs(TreeNode node) {
        if (node != null) {
            dfs(node.left); // 左
            queue.add(node); // 根
            dfs(node.right); // 右
        }
    }
}

