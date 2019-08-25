package com.xiongzehua.learning.algorithm.test.pingduoduo4;

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
            int target = Integer.valueOf(args[1]);
            args = in.nextLine().trim().split(" ");
            int[] nums = toIntArgs(args);
            Arrays.sort(nums);

            int min = Integer.MAX_VALUE;
            for (int i = target - 1; i < nums.length; i++) {
                int temp = 0;
                for (int j = 0; j < target; j++) {
                    temp = temp + nums[i] - nums[i - j];
                }
                if (temp < min)
                    min = temp;
            }
            System.out.println(min);
        }
    }

    public static int[] toIntArgs(String[] args) {
        int[] intArgs = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            intArgs[i] = Integer.valueOf(args[i]);
        }
        return intArgs;
    }
}





