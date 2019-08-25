package com.xiongzehua.learning.algorithm.util;

import java.util.LinkedList;

/**
 * Created by xiongzehua on 2018/12/13.
 */
public class FirstComparator {

    // 对于每一个元素，找出从左向右看，第一个比他大的元素（返回它的角标）
    // 思路：逆序进队列，单调递减队列
    public static int[] sequenceAndBigger(int[] value) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] index = new int[value.length];
        for (int i = value.length - 1; i >= 0; i--) {
            while (list.size() != 0) {
                int tail = list.getLast();
                if (value[tail] <= value[i])
                    list.removeLast();
                else
                    break;
            }
            if (list.size() != 0)
                index[i] = list.getLast();
            else
                index[i] = index.length;
            list.addLast(i);
        }
        return index;
    }

    // 对于每一个元素，找出从左向右看，第一个比他小的元素（返回它的角标）
    // 思路：逆序进队列，单调递增队列
    public static int[] sequenceAndSmaller(int[] value) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] index = new int[value.length];
        for (int i = value.length - 1; i >= 0; i--) {
            while (list.size() != 0) {
                int tail = list.getLast();
                if (value[tail] >= value[i])
                    list.removeLast();
                else
                    break;
            }
            if (list.size() != 0)
                index[i] = list.getLast();
            else
                index[i] = index.length;
            list.addLast(i);
        }
        return index;
    }

    // 对于每一个元素，找出从右向左看，第一个比他小的元素（返回它的角标）
    // 思路：逆序进队列，单调递增队列
    public static int[] reverseAndSmaller(int[] value) {
        LinkedList<Integer> list = new LinkedList<>();
        int[] index = new int[value.length];
        for (int i = 0; i < value.length; i++) {
            while (list.size() != 0) {
                int tail = list.getLast();
                if (value[tail] >= value[i])
                    list.removeLast();
                else
                    break;
            }
            if (list.size() != 0)
                index[i] = list.getLast();
            else
                index[i] = -1;
            list.addLast(i);
        }
        return index;
    }
}
