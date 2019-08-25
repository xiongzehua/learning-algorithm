package com.xiongzehua.learning.algorithm.dynamicProgramming;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xiongzehua on 2019/1/26.
 */
public class MinPathSumTest {
    @Test
    public void test() {
        int[][] case1 = {{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        Assert.assertEquals(12, MinPathSum.work(case1));
        Assert.assertEquals(12, MinPathSum.workFromAnswer(case1));

        int[][] case2 = {{1, 3, 5, 9, 12}, {8, 1, 3, 4, 7}, {5, 0, 6, 1, 4}, {8, 8, 4, 0, 5}, {8, 8, 4, 0, 3}};
        Assert.assertEquals(15, MinPathSum.work(case2));
        Assert.assertEquals(15, MinPathSum.workFromAnswer(case2));

        int[][] case3 = {{2, 4, 6, 9}, {8, 1, 2, 4}, {6, 6, 6, 1}, {8, 9, 4, 0}, {8, 1, 2, 0}, {8, 5, 6, 2}};
        Assert.assertEquals(16, MinPathSum.work(case3));
        Assert.assertEquals(16, MinPathSum.workFromAnswer(case3));

    }

}
