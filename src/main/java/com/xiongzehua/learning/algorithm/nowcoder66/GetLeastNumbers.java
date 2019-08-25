package com.xiongzehua.learning.algorithm.nowcoder66;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.stream.Collectors;

/**
 * Created by xiongzehua on 2019/3/14.
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length < k || k == 0)
            return list;
        // 构建大顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        for (int num : input) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else {
                if (num < priorityQueue.peek()) {
                    priorityQueue.remove();
                    priorityQueue.add(num);
                }
            }
        }

        while (priorityQueue.size() > 0) {
            list.add(priorityQueue.remove());
        }
        Collections.reverse(list);
        return list;
    }
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input.length < k || k == 0)
            return list;
        // 构建小顶堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int num : input) {
            priorityQueue.add(num);
        }
        for (int i = 0; i < k; i++) {
            list.add(priorityQueue.remove());
        }
        return list;
    }
}
