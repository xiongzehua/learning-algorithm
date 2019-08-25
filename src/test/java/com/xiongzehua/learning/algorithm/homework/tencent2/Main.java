package com.xiongzehua.learning.algorithm.homework.tencent2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by xiongzehua on 2019/4/2.
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            line = in.nextLine().trim();
            System.out.println(minLength(line));
        }
    }

    public static int minLength(String str) {
        char[] chars = str.toCharArray();
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            Node node = new Node(chars[i] - '0');
            list.add(node);
        }

        while (true) {
            boolean hasDeleted = false;

            for (int i = 0; i < list.size() - 1;) {
                Node node1 = list.get(i);
                Node node2 = list.get(i + 1);
                if (node1.value != node2.value) {
                    node1.delete = true;
                    node2.delete = true;
                    hasDeleted = true;
                    i = i + 2;
                } else {
                    i = i + 1;
                }
            }

            ArrayList<Node> newList = new ArrayList<>(list.size() / 2);
            for (int i = 0; i < list.size(); i++) {
                Node node = list.get(i);
                if (!node.delete) {
                    newList.add(node);
                }
            }
            list = newList;
            if (!hasDeleted)
                break;
        }

        return list.size();
    }
}

class Node {
    int value;
    boolean delete = false;

    public Node(int value) {
        this.value = value;
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




