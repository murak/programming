package com.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question: https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 */
public class DFSUsingSimpleGraphWrapper {

    // Driver Code
    public static void main(String args[])
    {
        DFSUsingSimpleGraph g = new DFSUsingSimpleGraph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 0);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(2, 5);
        g.addEdge(4, 5);
        g.addEdge(4, 1);
        g.addEdge(5, 1);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.dfs(2);
    }

}

class DFSUsingSimpleGraph {

    private final int numOfVertices;

    private final List<List<Integer>> adjList;

    private final boolean[] visited;

    public DFSUsingSimpleGraph(final int numOfVertices) {
        this.numOfVertices = numOfVertices;
        this.adjList = new ArrayList<>();
        for (int vertex = 0; vertex < numOfVertices; vertex++) {
            this.adjList.add(new ArrayList<>());
        }
        this.visited = new boolean[numOfVertices];
        Arrays.fill(visited, false);
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    public void dfs(int source) {
        // First process the node and mark it as visited
        System.out.println("visiting node: " + source);
        visited[source] = true;

        // For each neighbor 'v' of the source node
        for (Integer v : adjList.get(source)) {
            // if neighbor 'v' is not visited already, then visit it recursively.
            if (!visited[v]) {
                dfs(v);
            }
        }

    }
}
