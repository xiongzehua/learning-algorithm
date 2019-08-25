package com.xiongzehua.learning.algorithm.homework.jingdong2;

/**
 * Created by xiongzehua on 2019/4/2.
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            args = in.nextLine().trim().split(" ");
            int cnt = Integer.valueOf(args[0]);

            LinkedList<char[]> keys = new LinkedList<>();
            for (int i = 0; i < cnt; i++) {
                keys.add(in.nextLine().trim().toCharArray());
            }
            char[] chars = in.nextLine().trim().toCharArray();
            int[] dp = new int[chars.length];
            for (int i = 0; i < dp.length; i++) {
                int max = 0;
                if (i != 0) {
                    max = dp[i - 1];
                }
                for (char[] key : keys) {
                    int temp = 0;
                    if (match(chars, i, key)) {
                        if (i - key.length == -1)
                            temp = 1;
                        else
                            temp = dp[i - key.length] + 1;
                        if (max < temp) {
                            max = temp;
                        }
                    }
                }
                dp[i] = max;
            }
            System.out.println(dp[dp.length - 1]);
        }
    }

    public static boolean match(char[] chars, int index, char[] key) {
        boolean matched = true;
        try {
            for (int i = 0; i < key.length; i++) {
                if (chars[index - i] != key[key.length - 1 - i]) {
                    matched = false;
                    break;
                }
            }
        } catch (Exception e) {
            matched = false;
        }
        return matched;
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





