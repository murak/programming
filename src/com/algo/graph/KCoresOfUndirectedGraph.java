package com.algo.graph;

import java.util.*;

/**
 * Question: https://www.geeksforgeeks.org/find-k-cores-graph/
 */
class KCoreGraph {
    private List<List<Integer>> adj;

    public KCoreGraph(int size) {
        adj = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(final int u, final int v) {
        adj.get(u).add(v);
    }

    private void _dfs(final int s, final int k, final boolean[] visited, final int[] degree) {
        visited[s] = true;
        for (int v : adj.get(s)) {
            if (degree[s] < k) {
                degree[v]--;
            }
            if (!visited[v]) {
                _dfs(v, k, visited, degree);
                if (degree[v] < k) {
                    degree[s]--;
                }
            }
        }
    }

    public void dfs(int s, int k) {
        boolean[] visited = new boolean[adj.size()];
        int[] degree = new int[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            degree[i] = adj.get(i).size();
        }
        System.out.println("Initial degree of vertices in graph: " + Arrays.toString(degree));

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                _dfs(i, k, visited, degree);
            }
        }

        System.out.println("Degree of vertices after running DFS: " + Arrays.toString(degree));
        System.out.println("Final graph :");

        for (int i = 0; i < adj.size(); i++) {
            if (degree[i] >= k) {
                System.out.print(i+" -->\t");
                for (int v : adj.get(i)) {
                    if (degree[v] >= k) {
                        System.out.print(v + "\t");
                    }
                }
            }
            System.out.println();
        }
    }
}


public class KCoresOfUndirectedGraph {

    public static void main(String[] args) {
        KCoreGraph g = new KCoreGraph(9);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,0);
        g.addEdge(1,2);
        g.addEdge(1,5);
        g.addEdge(2,0);
        g.addEdge(2,1);
        g.addEdge(2,5);
        g.addEdge(2,4);
        g.addEdge(2,3);
        g.addEdge(2,6);
        g.addEdge(3,2);
        g.addEdge(3,4);
        g.addEdge(3,6);
        g.addEdge(3,7);
        g.addEdge(4,2);
        g.addEdge(4,3);
        g.addEdge(4,6);
        g.addEdge(4,7);
        g.addEdge(5,1);
        g.addEdge(5,2);
        g.addEdge(5,6);
        g.addEdge(5,8);
        g.addEdge(6,2);
        g.addEdge(6,3);
        g.addEdge(6,4);
        g.addEdge(6,8);
        g.addEdge(6,5);
        g.addEdge(6,7);
        g.addEdge(7,3);
        g.addEdge(7,4);
        g.addEdge(7,6);
        g.addEdge(8,5);
        g.addEdge(8,6);

        g.dfs(0, 3);
    }

}
