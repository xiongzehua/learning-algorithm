package com.xiongzehua.learning.algorithm;

import java.util.Arrays;

/**
 * Created by xiongzehua on 2018/9/15.
 */
public class LeetCode63 {
    private int[][] obstacleGrid;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                }
            }
        }
        this.obstacleGrid = obstacleGrid;
        int result = getValue(obstacleGrid.length -1, obstacleGrid[0].length - 1);
        return result;
    }
    private int getValue(int i, int j) {
        if (obstacleGrid[i][j] == -1)
            return 0;
        if (i > 0 && j > 0) {
            if (obstacleGrid[i][j] == 0)
                obstacleGrid[i][j] = getValue(i - 1, j) + getValue(i, j - 1);
        } else if (i <= 0 && j > 0) {
            if (obstacleGrid[i][j] == 0)
                obstacleGrid[i][j] = getValue(i, j - 1);
        } else if (i > 0 && j <= 0) {
            if (obstacleGrid[i][j] == 0)
                obstacleGrid[i][j] = getValue(i - 1, j);
        } else {
            obstacleGrid[0][0] = 1;
        }
        return obstacleGrid[i][j];
    }
}
