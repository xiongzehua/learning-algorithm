package com.xiongzehua.learning.algorithm.test.pingduoduo1;

/**
 * Created by xiongzehua on 2019/4/2.
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            System.out.println(maxDelete(line));
        }
    }

    public static int maxDelete(String str) {
        int cnt = 0;
        char[] chars = str.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        stack.push('0'); // init
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == stack.peek()) {
                stack.pop();
                cnt++;
            } else {
                stack.push(chars[i]);
            }
        }
        return cnt;
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





