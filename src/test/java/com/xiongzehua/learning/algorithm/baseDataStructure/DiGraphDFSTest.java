package com.xiongzehua.learning.algorithm.baseDataStructure;

import org.junit.Test;

/**
 * Created by xiongzehua on 2019/3/1.
 */
public class DiGraphDFSTest {

    @Test
    public void dfs() {
        DiGraphDFS.dfs1(TestCase.diGraph1(), 0);
        DiGraphDFS.dfs1(TestCase.diGraph1(), 8);

        DiGraphDFS.dfs2(TestCase.diGraph1(), 0);
        DiGraphDFS.dfs2(TestCase.diGraph1(), 8);
    }
}