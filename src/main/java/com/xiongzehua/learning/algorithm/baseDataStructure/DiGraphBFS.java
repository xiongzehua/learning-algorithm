package com.xiongzehua.learning.algorithm.baseDataStructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 类似于树的层次遍历，基于队列实现
 * Created by xiongzehua on 2019/3/1.
 */
public class DiGraphBFS {

    public static void bfs(HashMap<Integer, List<Integer>> diGraph, Integer sourceVertex) {
        System.out.print(sourceVertex + "可到达点为: ");

        LinkedList<Integer> queue = new LinkedList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        queue.add(sourceVertex);
        visited.put(sourceVertex, true);

        while (!queue.isEmpty()) {
            Integer startVertex =  queue.remove();
            System.out.print(startVertex + ", ");
            List<Integer> endVertexs = diGraph.get(startVertex);
            for (Integer v : endVertexs) {
                if(visited.get(v) == null) {
                    queue.add(v);
                    visited.put(v, true);
                }
            }
        }

        System.out.println();
    }
}
