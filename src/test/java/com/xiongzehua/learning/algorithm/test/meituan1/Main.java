package com.xiongzehua.learning.algorithm.test.meituan1;

/**
 * Created by xiongzehua on 2019/4/2.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            args = in.nextLine().trim().split(" ");
            int n = Integer.valueOf(args[0]);
            int m = Integer.valueOf(args[1]);
            int[][] array = new int[n][m];


            for (int i = 0; i < n; i++) {
                args = in.nextLine().trim().split(" ");
                int[] nums = toIntArgs(args);
                array[i] = nums;
            }
            System.out.println(modifyCount(array));
        }
    }

    public static int modifyCount(int[][] array) {
        int totalNum = array.length * array[0].length;
        HashMap<Integer, Node> blackMap = new HashMap<>();
        HashMap<Integer, Node> writeMap = new HashMap<>();
        ArrayList<Node> blackList = new ArrayList<>();
        ArrayList<Node> writeList = new ArrayList<>();
        int status = 0;
        for (int i = 0; i < array.length; i++) {
            int statusInRow = status;
            for (int j = 0; j < array[0].length; j++) {
                if (statusInRow == 0) { // 黑格子
                    if (blackMap.containsKey(array[i][j])) {
                        blackMap.get(array[i][j]).increase();
                    } else {
                        Node node1 = new Node(array[i][j]);
                        blackMap.put(array[i][j], node1);
                        blackList.add(node1);
                    }
                } else { // 白格子
                    if (writeMap.containsKey(array[i][j])) {
                        writeMap.get(array[i][j]).increase();
                    } else {
                        Node node2 = new Node(array[i][j]);
                        writeMap.put(array[i][j], node2);
                        writeList.add(node2);
                    }
                }
                statusInRow = (statusInRow + 1) % 2;
            }
            status = (status + 1) % 2;
        }

        Collections.sort(blackList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.cnt - o1.cnt;
            }
        });
        Collections.sort(writeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.cnt - o1.cnt;
            }
        });
//        System.out.println(blackMap);
//        System.out.println(blackList);
//        System.out.println(writeMap);
//        System.out.println(writeList);

        int temp = 0;
        if (blackList.get(0).key == writeList.get(0).key) {
            if (blackList.size() >= 2 && writeList.size() >= 2) {
                temp = Math.max(blackList.get(0).cnt + writeList.get(1).cnt,
                        blackList.get(1).cnt + writeList.get(0).cnt);
            } else if (blackList.size() < 2 && writeList.size() >= 2) {
                temp = blackList.get(0).cnt + writeList.get(1).cnt;
            } else if (blackList.size() >= 2 && writeList.size() < 2) {
                temp = writeList.get(0).cnt + blackList.get(1).cnt;
            } else {
                temp = Math.max(blackList.get(0).cnt, writeList.get(0).cnt);
            }

        } else {
            temp = blackList.get(0).cnt + writeList.get(0).cnt;
        }
        return  totalNum - temp;
    }

    public static int[] toIntArgs(String[] args) {
        int[] intArgs = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            intArgs[i] = Integer.valueOf(args[i]);
        }
        return intArgs;
    }
}
class Node {
    int key;
    int cnt;

    public Node(int key) {
        this.key = key;
        this.cnt = 1;
    }
    public void increase() {
        cnt++;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", cnt=" + cnt +
                '}';
    }
}

class MyUtil {


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





