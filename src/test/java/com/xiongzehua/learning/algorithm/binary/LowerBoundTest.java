package com.xiongzehua.learning.algorithm.binary;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 查找nums中第一个大于等于target的元素的位置
 * Created by xiongzehua on 2019/3/3.
 */
public class LowerBoundTest {

    @Test
    public void lowerBound() {
        // index       0  1  2  3  4  5  6
        int[] case1 = {0, 1, 3, 3, 3, 5, 8};
        System.out.println(new LowerBound().lowerBound(case1, -1)); // 0
        System.out.println(new LowerBound().lowerBound(case1, 0)); // 0
        System.out.println(new LowerBound().lowerBound(case1, 2)); // 2
        System.out.println(new LowerBound().lowerBound(case1, 3)); // 2
        System.out.println(new LowerBound().lowerBound(case1, 4)); // 5
        System.out.println(new LowerBound().lowerBound(case1, 8)); // 6
        System.out.println(new LowerBound().lowerBound(case1, 10)); // 7
    }
}