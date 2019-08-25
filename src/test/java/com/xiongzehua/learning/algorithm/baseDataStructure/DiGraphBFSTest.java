package com.xiongzehua.learning.algorithm.baseDataStructure;

import org.junit.Test;

/**
 * Created by xiongzehua on 2019/3/1.
 */
public class DiGraphBFSTest {

    @Test
    public void bfs() {
        DiGraphBFS.bfs(TestCase.diGraph1(), 0);
        DiGraphBFS.bfs(TestCase.diGraph1(), 8);
    }
}