package com.xiongzehua.learning.algorithm.homework.zhaohang2;

/**
 * Created by xiongzehua on 2019/4/2.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            args = in.nextLine().trim().split(" ");
            long w = Integer.valueOf(args[1]);
            w = w * 1000000;

            args = in.nextLine().trim().split(" ");
            long[] nums = MyUtil.toIntArgs(args);
            Arrays.sort(nums);

            long a = nums[0] * 1000000;
            long b = nums[nums.length / 2] * 1000000 / 2;
            long total = 0;
            if (b < a) {
                total = b * 3 * nums.length / 2;
            } else {
                total = a * 3 * nums.length / 2;
            }
            if (total > w)
                total = w;

            String totalStr = String.valueOf(total);
            StringBuilder totalSb = new StringBuilder(totalStr);
            totalSb.insert(totalSb.length() - 6, '.');
            System.out.println(totalSb.toString());
        }
    }
}

class MyUtil {
    public static long[] toIntArgs(String[] args) {
        long[] intArgs = new long[args.length];
        for (int i = 0; i < args.length; i++) {
            intArgs[i] = Integer.valueOf(args[i]);
        }
        return intArgs;
    }
}


