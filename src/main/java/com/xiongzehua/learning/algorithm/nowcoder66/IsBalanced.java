package com.xiongzehua.learning.algorithm.nowcoder66;

/**
 * 平衡二叉树
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11192&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * Created by xiongzehua on 2019/3/9.
 */
public class IsBalanced {
    private boolean balance = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return  balance;
    }

    // 返回node节点的深度
    private int dfs(TreeNode node) {
        int left = 0, right = 0;
        if (node != null) {
            left = dfs(node.left);
            right = dfs(node.right);
            if (Math.abs(left - right) > 1)
                balance = false;
        }
        return Math.max(left, right) + 1;
    }
}
