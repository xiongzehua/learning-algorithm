package com.xiongzehua.learning.algorithm.nowcoder66;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xiongzehua on 2019/3/14.
 */
public class GetLeastNumbersTest {
    @Test
    public void test() {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(new GetLeastNumbers().GetLeastNumbers_Solution(array, 5));
    }
}