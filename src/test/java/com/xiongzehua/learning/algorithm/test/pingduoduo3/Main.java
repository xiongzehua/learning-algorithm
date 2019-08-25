package com.xiongzehua.learning.algorithm.test.pingduoduo3;

/**
 * Created by xiongzehua on 2019/4/2.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            args = in.nextLine().trim().split(" ");
            int cnt = Integer.valueOf(args[0]);
            int k = Integer.valueOf(args[1]);

            int[][] list = new int[cnt][2];
            int min = 0;
            int max = 0;
            for (int i = 0; i < cnt; i++) {
                args = in.nextLine().trim().split(" ");
                int[] ints = toIntArgs(args);
                Arrays.sort(ints);
                list[i] = ints;
                if (list[i][0] < min)
                    min = list[i][0];
                if (list[i][1] > max)
                    max = list[i][1];
            }

            int[] points = new int[max - min];
            for (int i = 0; i < list.length; i++) {
                for (int j = list[i][0] - min; j < list[i][1] - min; j++) {
                    points[j]++;
                }
            }

            ArrayList<int[]> result = new ArrayList<>();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < points.length; i++) {
                if(points[i] >= k) {
                    temp.add(i);
                } else {
                    if (temp.size() > 0) {
                        int[] v = new int[2];
                        v[0] = temp.get(0) + min;
                        v[1] = temp.get(temp.size() - 1) + min + 1;
                        result.add(v);
                        temp = new ArrayList<>();
                    }
                }
            }
            if (temp.size() > 0) {
                int[] v = new int[2];
                v[0] = temp.get(0) + min;
                v[1] = temp.get(temp.size() - 1) + min + 1;
                result.add(v);
            }
            System.out.println(result.size());
            for (int[] v : result) {
                System.out.println(v[0] + " "  + v[1]);
            }
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





