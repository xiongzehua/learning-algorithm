package com.xiongzehua.learning.algorithm.homework.kuaishou2;

/**
 * Created by xiongzehua on 2019/4/2.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            long n = Long.valueOf(in.nextLine().trim());
            long result = 1;
            for (int i = 1; i <= n; i++) {
                int k = i;
                while (k % 10 == 0) {
                    k = k / 10;
                }
                k = k % 10;
                result = result * k;
                while (result % 10 == 0) {
                    result = result / 10;
                }
                result = result % 10;
            }
            System.out.println(result);
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


