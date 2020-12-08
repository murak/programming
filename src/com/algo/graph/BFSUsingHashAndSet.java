package com.algo.graph;

import java.util.*;

class HashSetBasedGraph {

    private HashMap<Integer, Set<Integer>> ajdList;

    public HashSetBasedGraph(final int size) {
        ajdList = new HashMap<>();
        for (int i = 0; i < size; i++) {
            ajdList.putIfAbsent(i, new HashSet<>());
        }
    }

    public void addEdge(final int u, final int v) {
        ajdList.get(u).add(v);
    }

    public void bfs(final int s) {
        int[] parent = new int[ajdList.size()];
        int[] color = new int[ajdList.size()];
        Arrays.fill(parent, -1);
        Deque<Integer> queue = new LinkedList<>();
        queue.add(s);
        parent[s] = -999;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            color[u] = 0;
            for (int v : ajdList.get(u)) {
                if (parent[v] == -1) {
                    color[v] = 0;
                    parent[v] = u;
                    queue.add(v);
                }
            }
            System.out.println("processed: " + u);
            color[u] = 1;
        }
    }
}

public class BFSUsingHashAndSet {

    public static void main(String[] args) {
        final HashSetBasedGraph g = new HashSetBasedGraph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(3, 0);
        g.addEdge(3, 2);
        g.addEdge(4, 5);
        g.addEdge(3, 5);
        g.addEdge(3, 4);

        g.bfs(0);
    }

}