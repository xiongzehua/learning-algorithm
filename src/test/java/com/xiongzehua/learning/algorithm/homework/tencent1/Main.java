package com.xiongzehua.learning.algorithm.homework.tencent1;

import java.util.Arrays;

/**
 * Created by xiongzehua on 2019/4/2.
 */

public class Main {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextLine()) {
//            args = in.nextLine().trim().split(" ");
//            int cnt = Integer.valueOf(args[0]);
//
//            for (int i = 0; i < cnt; i++) {
//                args = in.nextLine().trim().split(" ");
//            }
//        }
        int[] money = {1, 2, 5, 10};
        System.out.println(min(money, 20));

    }

    public static int min(int[] money, int target) {
        int[] dp = new int[target + 1];
        for (int i = 0; i < money.length; i++) {
            dp[money[i]] = 1;
        }
        if (dp[1] == 0)
            return -1;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] == 0) {
                int index = MyUtil.lowerBound(money, i);
                int lowerBoundMoney = money[index - 1];
                dp[i] = dp[i - lowerBoundMoney] + 1;
            }
        }
        int max = dp[1];
        System.out.println(Arrays.toString(dp));
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}

class MyUtil {
    public static int[] toIntArgs(String[] args) {
        int[] intArgs = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            intArgs[i] = Integer.valueOf(args[i]);
        }
        return intArgs;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public static int lowerBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target)
                high = mid;
            else
                low = mid + 1;
        }
        return low;
    }
}


