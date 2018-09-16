package com.xiongzehua.learning.algorithm;

/**
 * Created by xiongzehua on 2018/9/16.
 */
public class LeetCode64 {
    private int[][] min;
    private int[][] grid;
    public int minPathSum(int[][] grid) {
        this.grid = grid;
        min = new int[grid.length][grid[0].length];
        min[0][0] = grid[0][0];
        return getMin(grid.length -1 , grid[0].length - 1);
    }

    /**
     * 获取角标为i, j的格子最小路径的值
     * 此值为这个格子左边和上面其中值最小的那个，加上此格子本身对应的值
     */
    private int getMin(int i, int j) {
        if (min[i][j] != 0)
            return min[i][j];

        if (i > 0 && j > 0) {
            min[i][j] = grid[i][j] + Math.min(getMin(i - 1, j), getMin(i, j - 1));
        } else if (i <= 0 && j > 0) {
            min[i][j] = grid[i][j] + getMin(i, j - 1);
        } else if (i > 0 && j <= 0) {
            min[i][j] = grid[i][j] + getMin(i - 1, j);
        } else {
        }
        return min[i][j];
    }
}
