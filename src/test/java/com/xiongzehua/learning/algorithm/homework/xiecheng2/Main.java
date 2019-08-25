package com.xiongzehua.learning.algorithm.homework.xiecheng2;

import java.util.Scanner;

/**
 * Created by xiongzehua on 2019/4/2.
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            line = line.replace("[", "");
            line = line.replace("]", "");
            args = line.trim().split(",");
            int[] nums = MyUtil.toIntArgs(args);

            int k = Integer.valueOf(in.nextLine().trim());
            int i = 0; int j = k - 1;
            while (j < nums.length) {
                MyUtil.reverse(nums, i, j);
                i = j + 1;
                j = i + k - 1;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int m = 0; m < nums.length - 1; m++) {
                sb.append(nums[m]);
                sb.append(",");
            }
            sb.append(nums[nums.length - 1]);
            sb.append("]");
            System.out.println(sb.toString());
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

    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}


