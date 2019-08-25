package com.xiongzehua.learning.algorithm.homework.xiecheng3;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by xiongzehua on 2019/4/2.
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            args = in.nextLine().trim().split(" +");
            HashMap<String, Count> map = new HashMap<>();
            for (int i = 1; i < args.length; i++) {
                String str = args[i];
                StringBuilder sb = new StringBuilder(str);
                if (sb.charAt(sb.length() - 1) == '/') sb.deleteCharAt(sb.length() - 1);
                if (sb.charAt(0) == '/') sb.deleteCharAt(0);
                str = sb.toString();
                if (map.containsKey(str)) {
                    map.get(str).cnt++;
                } else {
                    int length = str.trim().split("/").length;
                    map.put(str, new Count(length));
                }
                System.out.print(map.get(str).toString());
                System.out.print(" ");
            }
        }

    }
}

class Count {
    public Count(int length) {
        this.length = length;
        this.cnt = 1;
    }

    int length;
    int cnt;

    public String toString() {
        if (length == 1) return "1";
        if (length == 2) return "11";
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        for (int i = 0; i < length - 2; i++) {
            sb.append(cnt);
        }
        sb.append(1);
        return sb.toString();
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


