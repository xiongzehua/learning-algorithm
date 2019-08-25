package com.xiongzehua.learning.algorithm.test.pingduoduo2;

/**
 * Created by xiongzehua on 2019/4/2.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            args = in.nextLine().trim().split(" ");
            int n = Integer.valueOf(args[0]);
            int k = Integer.valueOf(args[1]);

            args = in.nextLine().trim().split(" ");
            long[] nums = toIntArgs(args);
            long total = 0;
            int cnt = k - 1;
            for (int i = 0; i < nums.length; i++) {
                total = total + nums[i];
                while (cnt > 0 && total > n) {
                    total = total - n;
                    cnt--;
                }
            }
            if (cnt == 0)
                System.out.println(total);
            else
                System.out.println(0);
        }

    }

    public static long[] toIntArgs(String[] args) {
        long[] intArgs = new long[args.length];
        for (int i = 0; i < args.length; i++) {
            intArgs[i] = Long.valueOf(args[i]);
        }
        return intArgs;
    }
}

class MyUtil {


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





