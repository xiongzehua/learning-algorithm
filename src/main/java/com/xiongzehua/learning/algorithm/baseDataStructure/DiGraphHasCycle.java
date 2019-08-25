package com.xiongzehua.learning.algorithm.baseDataStructure;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * 基于 dfs
 * Created by xiongzehua on 2019/3/1.
 */
public class DiGraphHasCycle {

    // static 静态成员变量初始化一定要在函数里做，不然第二次测试成员变量的值会是第一次测试用完的
    private HashMap<Integer, Boolean> visited = new HashMap<>();
    private HashMap<Integer, Boolean> onStack = new HashMap<>();
    private boolean hasCycle = false;

    public boolean hasCycle(HashMap<Integer, List<Integer>> diGraph) {
        Set<Integer> vertexs = diGraph.keySet();

        for (Integer v : vertexs) {
            if (visited.get(v) == null) {
                dfs(diGraph, v);
            }
        }
        return hasCycle;
    }

    // 基于递归实现
    private void dfs(HashMap<Integer, List<Integer>> diGraph, Integer sourceVertex) {
        System.out.print(sourceVertex + "可到达点为: ");

        dfsRecursion(diGraph, sourceVertex);
        System.out.println();
    }

    private void dfsRecursion(HashMap<Integer, List<Integer>> diGraph, Integer startVertex) {
        onStack.put(startVertex, true);

        visited.put(startVertex, true);
        System.out.print(startVertex + ", ");

        // 2. 将startVertex 所有对应的 endVertex进入递归
        List<Integer> endVertexs = diGraph.get(startVertex);
        for (Integer v : endVertexs) {
            if (onStack.get(v) != null) {// 递归栈上有这个顶点了
                System.out.print("[" + v + "], ");
                hasCycle = true;
            }
            if (visited.get(v) == null) {
                dfsRecursion(diGraph, v);
            }
        }
        onStack.put(startVertex, null);
    }
}
