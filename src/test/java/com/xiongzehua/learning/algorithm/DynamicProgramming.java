package com.xiongzehua.learning.algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    /**
     * LeetCode91 Decode Ways
     *
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given a non-empty string containing only digits, determine the total number of ways to decode it.
     *
     * Example 1:
     * Input: "12"
     * Output: 2
     * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
     *
     * Example 2:
     * Input: "226"
     * Output: 3
     * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     */
    @Test
    public void leetCode91() {
        assertEquals(2, new LeetCode91().numDecodings("12"));
        assertEquals(3, new LeetCode91().numDecodings("226"));
        assertEquals(1, new LeetCode91().numDecodings("27"));
        assertEquals(0, new LeetCode91().numDecodings("01"));
        assertEquals(0, new LeetCode91().numDecodings("303"));
    }


    /**
     * LeetCode120 Triangle
     *
     * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
     * For example, given the following triangle
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     * Note:
     * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
     */
    @Test
    public void leetCode120() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        assertEquals(11, new LeetCode120().minimumTotal(triangle));
    }

}
