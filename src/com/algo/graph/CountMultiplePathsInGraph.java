package com.algo.graph;

import java.util.*;

class SimpleMultiplePathGraph {
    private List<List<Integer>> adj;
    private int count = 0;

    public SimpleMultiplePathGraph(int size) {
        adj = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    public int countPath(int s, int d) {
        boolean[] visited = new boolean[adj.size()];
        count = 0;
        _count(s, d, visited);
        return count;
    }

    private int _count(int s, int d, boolean[] visited) {
        visited[s] = true;
        for (int v : adj.get(s)) {
            if (v == d) {
                count++;
            } else if (!visited[v]) {
                _count(v, d, visited);
                // After visiting a node, reset the visited back to false to let DFS reuse the node via alternate paths.
                visited[v] = false;
            }
        }
        return count;
    }
}

public class CountMultiplePathsInGraph {
    public static void main(String[] args) {
        SimpleMultiplePathGraph g = new SimpleMultiplePathGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);

        System.out.println("number of paths = " + g.countPath(0, 3));
    }
}
