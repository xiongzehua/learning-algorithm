package com.xiongzehua.learning.algorithm.baseDataStructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * HashMap表示邻接表
 * E: v -> w
 * key -- 顶点号
 * value -- 此顶点的边集
 *
 * 类似于树的中序遍历，可以用递归和栈实现
 * Created by xiongzehua on 2019/1/26.
 */
public class DiGraphDFS {
    private static HashMap<Integer, Boolean> visited;

    // 基于递归实现
    public static void dfs1(HashMap<Integer, List<Integer>> diGraph, Integer sourceVertex) {
        System.out.print(sourceVertex + "可到达点为: ");

        // 1. 创建到达标志 map
        visited = new HashMap<>();

        // 2. 递归遍历
        dfsRecursion(diGraph, sourceVertex);

        System.out.println();
    }

    private static void dfsRecursion(HashMap<Integer, List<Integer>> diGraph, Integer startVertex) {
        // 1. startVertex 标志为true
        visited.put(startVertex, true);
        System.out.print(startVertex + ", ");

        // 2. 将startVertex 所有对应的 endVertex进入递归
        List<Integer> endVertexs = diGraph.get(startVertex);
        for (Integer v : endVertexs) {
            if (visited.get(v) == null)
                dfsRecursion(diGraph, v);
        }

    }

    // 基于栈实现
    public static void dfs2(HashMap<Integer, List<Integer>> diGraph, Integer sourceVertex) {
        System.out.print(sourceVertex + "可到达点为: ");

        visited = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();

        stack.push(sourceVertex);
        visited.put(sourceVertex, true);

        while (!stack.isEmpty()) {
            Integer startVertex =  stack.pop();
            System.out.print(startVertex + ", ");
            List<Integer> endVertexs = diGraph.get(startVertex);
            for (Integer v : endVertexs) {
                if(visited.get(v) == null) {
                    stack.push(v);
                    visited.put(v, true);
                }
            }
        }

        System.out.println();
    }
}
