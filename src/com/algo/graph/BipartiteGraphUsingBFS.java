package com.algo.graph;

import java.util.*;

public class BipartiteGraphUsingBFS {

    public static void main(String[] args) {
        SimpleBiPartiteGraph g = new SimpleBiPartiteGraph(6);
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

        System.out.println(g.isBipartite());
    }

}

class SimpleBiPartiteGraph {

    private List<List<Integer>> adjList;

    public SimpleBiPartiteGraph(final int size) {
        adjList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(final int u, final int v) {
        adjList.get(u).add(v);
    }

    public boolean isBipartite() {
        int[] color = new int[adjList.size()];
        int[] parent = new int[adjList.size()];
        Arrays.fill(color, -1); // initialize as invalid color
        Arrays.fill(parent, -1); // initialize as invalid parent
        boolean isBipartite = true;
        for (int s = 0; s < adjList.size(); s++) {
            // cover all disconnected components in the forest
            if (parent[s] == -1) {
                // if any component is not bipartite, the whole graph is not bipartite
                isBipartite = isBipartite && _isBipartite(s, color, parent);
            }
        }
        return isBipartite;
    }

    private boolean _isBipartite(int s, int[] color, int[] parent) {
        final List<Integer> queue = new ArrayList<>();
        queue.add(s);
        color[s] = 0;
        parent[s] = -999; // initialize parent to NULL
        while (queue.size() != 0) { // till queue is empty
            int u = queue.remove(0);
            for (int v : adjList.get(u)) {
                // if vertex v is encountered with same color, then the graph is not bipartite
                if (color[u] == color[v]) {
                    return false;
                }
                // If the vertex was not already visited, then visit it.
                if (parent[v] == -1) {
                    color[v] = 1 - color[u];
                    parent[v] = u;
                    queue.add(v);
                }
            }
        }
        return true;
    }
}