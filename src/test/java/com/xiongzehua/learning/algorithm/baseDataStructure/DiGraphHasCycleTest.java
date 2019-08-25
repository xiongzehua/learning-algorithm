package com.xiongzehua.learning.algorithm.baseDataStructure;

import org.junit.Test;

/**
 * Created by xiongzehua on 2019/3/2.
 */
public class DiGraphHasCycleTest {

    @Test
    public void hasCycle() {
        System.out.println(new DiGraphHasCycle().hasCycle(TestCase.diGraph1()));
        System.out.println(new DiGraphHasCycle().hasCycle(TestCase.diGraph2()));
    }
}