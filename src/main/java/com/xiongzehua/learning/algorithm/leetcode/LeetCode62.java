package com.xiongzehua.learning.algorithm.leetcode;

/**
 * a[i][j] = a[i-1][j] + a[i][j-1]
 * a[0][0] = 0; a[0][1] = 1; a[1][0] = 1;
 * a[i][j] = ?
 *
 * Created by xiongzehua on 2018/9/14.
 */
public class LeetCode62 {
    int[][] a;
    public int uniquePaths(int m, int n) {
        a = new int[m][n];
        return getValue(m - 1, n - 1);
    }
    private int getValue(int i, int j) {
        if (i > 0 && j > 0) {
            if (a[i][j] == 0)
                a[i][j] = getValue(i - 1, j) + getValue(i, j - 1);
        } else if (i <= 0 && j > 0) {
            if (a[i][j] == 0)
                a[i][j] = getValue(i, j - 1);
        } else if (i > 0 && j <= 0) {
            if (a[i][j] == 0)
                a[i][j] = getValue(i - 1, j);
        } else {
            a[0][0] = 1;
        }
        return a[i][j];
    }
}
