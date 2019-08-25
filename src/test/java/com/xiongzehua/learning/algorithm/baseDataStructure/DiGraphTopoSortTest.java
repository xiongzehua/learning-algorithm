package com.xiongzehua.learning.algorithm.baseDataStructure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xiongzehua on 2019/3/3.
 */
public class DiGraphTopoSortTest {

    @Test
    public void topoSort() {
        new DiGraphTopoSort().topoSort(TestCase.diGraph2());
    }
}