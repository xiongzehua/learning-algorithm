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
     * LeetCode62. Unique Paths
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
        assertEquals(new LeetCode62().uniquePaths(7, 3), 28);
        assertEquals(new LeetCode62().uniquePaths(1, 1), 1);
        assertEquals(new LeetCode62().uniquePaths(2, 1), 1);
    }
}
