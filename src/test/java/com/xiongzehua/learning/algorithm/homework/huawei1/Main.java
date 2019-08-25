package com.xiongzehua.learning.algorithm.homework.huawei1;

/**
 * Created by xiongzehua on 2019/4/2.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        args = in.nextLine().trim().split(" ");
        int k = Integer.valueOf(args[0]);
        ArrayList<int[]> list = new ArrayList<>();
        while (in.hasNextLine()) {
            args = in.nextLine().trim().split(",");
            int[] a = MyUtil.toIntArgs(args);
            list.add(a);
        }

        int[] merge = merge(list, k);

        System.out.print(merge[0]);
        for (int i = 1; i < merge.length; i++) {
            System.out.print(",");
            System.out.print(merge[i]);
        }
        System.out.println();
    }

    public static int[] merge(ArrayList<int[]> list, int k) {
        int length = 0;
        for (int[] a : list) {
            length = length + a.length;
        }
        int[] merge = new int[length];
        int[] p = new int[list.size()];
        int pmerge = 0;
        while (pmerge < merge.length) {
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < k; j++) {
                    if (p[i] < list.get(i).length) {
                        merge[pmerge] = list.get(i)[p[i]];
                        p[i] = p[i] + 1;
                        pmerge++;
                    }
                }
            }
        }
        return merge;
    }
}

class MyUtil {
    public static int[] toIntArgs(String[] args) {
        if (args.length == 0 || "".equals(args[0]))
            return new int[0];
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


