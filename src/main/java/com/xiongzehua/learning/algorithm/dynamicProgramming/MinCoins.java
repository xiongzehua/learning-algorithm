package com.xiongzehua.learning.algorithm.dynamicProgramming;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by xiongzehua on 2019/1/26.
 */
public class MinCoins {
    public static int work(int[] coins, int aim) {
        Arrays.sort(coins);
        int[] dp = new int[aim + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue();

            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j])
                    break;
                if (i == coins[j])
                    priorityQueue.add(1);
                if (dp[i-coins[j]] == 0)
                    ;
                else
                    priorityQueue.add(dp[i-coins[j]] + 1);
            }
            if (!priorityQueue.isEmpty())
                dp[i] = priorityQueue.remove();
        }
        System.out.println(Arrays.toString(dp));;
        return dp[aim];
    }

    public static int answer(int[] coins, int aim) {
        if (coins == null || coins.length == 0 || aim < 0) {
            return -1;
        }
        int n = coins.length;
        int max = Integer.MAX_VALUE;
        int[][] dp = new int[n][aim + 1];
        for (int j = 1; j <= aim; j++) {
            dp[0][j] = max;
            if (j - coins[0] >= 0 && dp[0][j - coins[0]] != max) {
                dp[0][j] = dp[0][j - coins[0]] + 1;
            }
        }
        int left = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - coins[i] >= 0 && dp[i][j - coins[i]] != max) {
                    left = dp[i][j - coins[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[n - 1][aim] != max ? dp[n - 1][aim] : -1;
    }
}
