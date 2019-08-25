package com.xiongzehua.learning.algorithm;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by xiongzehua on 2019/1/25.
 */
public class DataStructureTest {
    @Test
    public void testStack() {
        // 栈 LIFO
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack); // 3 2 1

        // peek操作与pop操作返回的元素一致，对于栈来说为最近入栈的元素
        System.out.println(stack.peek()); // 3

        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 2
        System.out.println(stack.pop()); // 1

        System.out.println(stack.peek()); // null
        System.out.println(stack.isEmpty()); // true
        System.out.println(stack.pop()); // NoSuchElementException
    }

    @Test
    public void testQueue() {
        // 队列 FIFO(first in first out)
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        // peek操作与remove操作返回的元素一致，对于来说为最久入队的元素
        System.out.println(queue.peek()); // 1

        System.out.println(queue.remove()); // 1
        System.out.println(queue.remove()); // 2
        System.out.println(queue.remove()); // 3

        System.out.println(queue.peek()); // null
        System.out.println(queue.isEmpty()); // true
        System.out.println(queue.remove()); // NoSuchElementException
    }

    /**
     * 数组转ArrayList
     */
    @Test
    public void test3() {
        Integer[] array = {1, 2, 3};

        // 方法一：Arrays.asList使用了视图的方式返回数据，只能改查，不能增删
        List<Integer> list1 = Arrays.asList(array);
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        System.out.println(list1.get(2));
        System.out.println(list2.get(2));

        try {
            // UnsupportedOperationException
            System.out.println(list1.add(4));
            System.out.println(list1.add(4));
        } catch (Exception e) {
            System.out.println(e);
        }

        // 方式二
        List<Integer> list3 = new ArrayList<>(Arrays.asList(array));
        list3.add(4);
        System.out.println(list3);

    }


    @Test
    public void test4() {
        PriorityBlockingQueue priorityQueue = new PriorityBlockingQueue(3);
        priorityQueue.add(6);
        priorityQueue.add(2);
        priorityQueue.add(8);
        priorityQueue.add(5);
        priorityQueue.add(3);

        System.out.println(priorityQueue);
    }
}
