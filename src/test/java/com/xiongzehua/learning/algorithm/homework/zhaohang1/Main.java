package com.xiongzehua.learning.algorithm.homework.zhaohang1;

import java.util.Scanner;

/**
 * Created by xiongzehua on 2019/4/2.
 */

public class Main {
    // 6:1 7:2 8:4 9:8   答案为 2^(n-6)
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n  = Integer.valueOf(in.nextLine().trim());
            int cnt = n - 6;
            if (cnt < 0) {
                System.out.println(0);
                continue;
            }
            if (cnt == 0) {
                System.out.println(1);
                continue;
            }
            long result = 1;
            for (int i = 0; i < cnt; i++) {
                result = result * 2;
                result = result % 666666666;
            }
            System.out.println(result % 666666666);
        }
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


