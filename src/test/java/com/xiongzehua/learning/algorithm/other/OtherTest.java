package com.xiongzehua.learning.algorithm.other;


import com.xiongzehua.learning.algorithm.leetcode.LeetCode84;
import org.junit.Assert;
import org.junit.Test;

/**
 * 未分类的题目先放在这里
 * Created by xiongzehua on 2018/9/14.
 */
public class OtherTest {
    @Test
    public void leetCode84() {
        int[] array1 = {2, 1, 5, 6, 2, 3};
        Assert.assertEquals(10, new LeetCode84().largestRectangleArea(array1));
        int[] array2 = {2, 1, 2};
        Assert.assertEquals(3, new LeetCode84().largestRectangleArea(array2));
    }

}
