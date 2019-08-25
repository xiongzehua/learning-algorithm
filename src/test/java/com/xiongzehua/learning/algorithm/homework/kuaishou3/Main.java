package com.xiongzehua.learning.algorithm.homework.kuaishou3;

/**
 * Created by xiongzehua on 2019/4/2.
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            args = in.nextLine().trim().split(",");
            int a = Integer.valueOf(args[0]);
            int b = Integer.valueOf(args[1]);

            LinkedList<Node> queue = new LinkedList<Node>();
            queue.add(new Node(a, 0));
            int cnt = 0;
            while (true) {
                Node temp = queue.remove();
                if (temp.value == b) {
                    System.out.println(temp.cnt);
                    break;
                }
                queue.add(new Node(temp.value + 1, temp.cnt + 1));
                queue.add(new Node(temp.value - 1, temp.cnt + 1));
                queue.add(new Node(temp.value * 2, temp.cnt + 1));
            }
        }
    }
}
class Node {
    int value;
    int cnt;
    public Node(int value, int cnt) {
        this.value = value;
        this.cnt = cnt;
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


