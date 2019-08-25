package com.xiongzehua.learning.algorithm.baseDataStructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by xiongzehua on 2019/3/2.
 */
public class DiGraphTopoSort {
    private HashMap<Integer, Boolean> visited = new HashMap<>();

    private LinkedList<Integer> preOrderQueue = new LinkedList<>();
    private LinkedList<Integer> postOrderQueue = new LinkedList<>();
    private LinkedList<Integer> reversePostOrderStack = new LinkedList<>();

    public void topoSort(HashMap<Integer, List<Integer>> diGraph) {
        Set<Integer> vertexs = diGraph.keySet();
        for (Integer v : vertexs) {
            if (visited.get(v) == null) {
                dfsRecursion(diGraph, v);
            }
        }

        System.out.println("dfs全图遍历的  前序排序：" + preOrderQueue);
        System.out.println("dfs全图遍历的  后序排序：" + postOrderQueue);
        System.out.println("dfs全图遍历的逆后序排序：" + reversePostOrderStack);
        System.out.println("拓扑排序：" + reversePostOrderStack);
    }

    private void dfsRecursion(HashMap<Integer, List<Integer>> diGraph, Integer startVertex) {
        if (visited.get(startVertex) == null) {
            visited.put(startVertex, true);
            preOrderQueue.add(startVertex);

            List<Integer> endVertexs = diGraph.get(startVertex);
            for (Integer v : endVertexs) {
                dfsRecursion(diGraph, v);
            }

            postOrderQueue.add(startVertex);
            reversePostOrderStack.push(startVertex);
        }
    }
}
