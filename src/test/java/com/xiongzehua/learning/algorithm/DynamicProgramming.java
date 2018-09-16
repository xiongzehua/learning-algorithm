package com.xiongzehua.learning.algorithm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 动态规划
 *
 * Created by xiongzehua on 2018/9/14.
 */
public class DynamicProgramming {
    /**
     * LeetCode62 Unique Paths
     * prior: 1
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * How many possible unique paths are there?
     *
     * Example 1:
     * Input: m = 3, n = 2
     * Output: 3
     * Explanation:
     * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down
     * 2. Right -> Down -> Right
     * 3. Down -> Right -> Right
     *
     * Example 2:
     * Input: m = 7, n = 3
     * Output: 28
     */
    @Test
    public void leetCode62() {
        assertEquals(28, new LeetCode62().uniquePaths(7, 3));
        assertEquals(1, new LeetCode62().uniquePaths(1, 1));
        assertEquals(1, new LeetCode62().uniquePaths(2, 1));
    }


    /**
     * LeetCode63 Unique Paths II
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * The robot can only move either down or right at any point in time.
     * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     *
     * Note: m and n will be at most 100.
     *
     * Example 1:
     *
     * Input:
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     * Output: 2
     * Explanation:
     * There is one obstacle in the middle of the 3x3 grid above.
     * There are two ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down -> Down
     * 2. Down -> Down -> Right -> Right
     */
    @Test
    public void leetCode63() {
        int[][] obstacleGrid = {{0,0,0}, {0,1,0}, {0,0,0}};
        assertEquals(2, new LeetCode63().uniquePathsWithObstacles(obstacleGrid));
    }


    /**
     * LeetCode64 Minimum Path Sum
     *
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     * Note: You can only move either down or right at any point in time.
     *
     * Example:
     * Input:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * Output: 7
     * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
     */
    @Test
    public void leetCode64() {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        assertEquals(7, new LeetCode64().minPathSum(grid));
    }

}
