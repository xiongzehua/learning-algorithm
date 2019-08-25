package com.xiongzehua.learning.algorithm.homework.jingdong1;

/**
 * Created by xiongzehua on 2019/4/2.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        args = in.nextLine().trim().split(" ");
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        while (in.hasNextLine()) {
            args = in.nextLine().trim().split(" ");
            if (args[0].equals("aaa")) break;
            int a = Integer.valueOf(args[1]);
            int b = Integer.valueOf(args[0]);
            if (map.get(a) == null) {
                map.put(a, new LinkedList<Integer>());
                map.get(a).add(b);
            } else {
                map.get(a).add(b);
            }
        }

        LinkedList<Integer> list = map.get(1);
        ArrayList<Integer> cnts = new ArrayList<>(list.size());
        for (Integer node : list) {
            cnts.add(cnt(map, node));
        }
        Collections.sort(cnts);
        System.out.println(cnts.get(cnts.size() - 1));
    }
    public static Integer cnt(HashMap<Integer, LinkedList<Integer>> map, int root) {
        int cnt = 1;
        LinkedList<Integer> list = map.get(root);
        if (list == null)
            return cnt;
        for (Integer node : list) {
            cnt = cnt + cnt(map, node);
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





