package com.xiongzehua.learning.algorithm.dynamicProgramming;

import java.util.LinkedList;

/**
 * Created by xiongzehua on 2019/1/26.
 */

public class MinPathSum {
    public static int  work(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int min = Math.min(m, n);

        Info[][] dp = new Info[matrix.length][matrix[0].length];

        /** 初始状态 */
        dp[0][0] = new Info(matrix[0][0], matrix[0][0]);
        for (int i = 1; i < n; i++) {
            dp[0][i] = new Info(matrix[0][i], matrix[0][i] + dp[0][i-1].total);
        }
        for (int j = 1; j < m; j++) {
            dp[j][0] = new Info(matrix[j][0], matrix[j][0] + dp[j-1][0].total);
        }
        // showDpTotal(dp);

        /**
         * matrix为mxn矩阵
         * 所有状态的拓扑序列
         * (0,0) -> (0,1)->...->(0,n) -> (1,0)->...->(m,1)->
         * (1,1) -> (1,2)->...->(1,n) -> (2,1)->...->(m,1)->
         * ...
         */
        for (int k = 1; k < min; k++) {
            dp[k][k] = new Info(matrix[k][k], Math.min(dp[k-1][k].total, dp[k][k-1].total) + matrix[k][k]);
            for (int i = k+1; i < n; i++) {
                dp[k][i] = new Info(matrix[k][i], Math.min(dp[k-1][i].total, dp[k][i-1].total) + matrix[k][i]);
            }
            for (int j = k+1; j < m; j++) {
                dp[j][k] = new Info(matrix[j][k], Math.min(dp[j-1][k].total, dp[j][k-1].total) + matrix[j][k]);
            }
            // showDpTotal(dp);
        }

        showDpValue(dp);
        showDpTotal(dp);

        int minPathSum = dp[m-1][n-1].total;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(dp[m-1][n-1].value);
        int x = m - 1;
        int y = n - 1;
        for (int i = 0; i < m + n - 2; i++) {
            int value = -1;
            if (x!= 0 && dp[x][y].total - dp[x][y].value == dp[x-1][y].total) {
                value= dp[x-1][y].value;
                x = x - 1;
            } else {
                value= dp[x][y-1].value;
                y = y - 1;
            }
            stack.push(value);
        }
        System.out.println("minPath为" + stack);
        return minPathSum;
    }

    public static int workFromAnswer(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = m[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + m[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void showDpTotal(Info[][] dp) {
        System.out.println("-----------DpTotal--------------");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] != null)
                    System.out.print(dp[i][j].total + ", ");
                else
                    System.out.print(0 + ", ");
            }
            System.out.println();
        }
    }

    public static void showDpValue(Info[][] dp) {
        System.out.println("-----------DpValue--------------");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (dp[i][j] != null)
                    System.out.print(dp[i][j].value + ", ");
                else
                    System.out.print(0 + ", ");
            }
            System.out.println();
        }
    }

    public static class Info {
        int value;
        int total;

        public Info(int value, int total) {
            this.value = value;
            this.total = total;
        }
    }

}

