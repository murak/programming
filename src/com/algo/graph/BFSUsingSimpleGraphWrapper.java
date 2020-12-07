package com.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BFSUsingSimpleGraphWrapper {

    // Driver method to
    public static void main(String args[])
    {
        BFSUsingSimpleGraph g = new BFSUsingSimpleGraph(6);

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


        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.bfs(2);
    }

}

class BFSUsingSimpleGraph {

    private int numberOfVertices;

    private List<List<Integer>> adjList;

    public BFSUsingSimpleGraph(final int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjList = new ArrayList<>();
        for (int vertex = 0; vertex < numberOfVertices; vertex++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(final int u, final int v) {
        adjList.get(u).add(v);
        // for undirected graph include line below
        // adjList.get(v).add(u);
    }

    public void bfs(final int u) {
        // Create visited node and initialize
        final boolean[] visited = new boolean[numberOfVertices];
        Arrays.fill(visited, false);

        // Create a queue and add first node into queue
        final List<Integer> queue = new ArrayList<>();
        queue.add(u);

        // Do this until queue is empty
        while (queue.size() != 0) {
            // Get first element from queue
            int node = queue.remove(0);

            // If node is not visited
            if (!visited[node]) {
                // visit node and mark as visited
                System.out.println("Visiting node " + node);
                visited[node] = true;

                // Find all unvisited neighbors of node and add them to the queue
                List<Integer> unvisitedNeighbors = adjList.get(node)
                        .stream()
                        .filter(v -> visited[v] == false)
                        .collect(Collectors.toList());
                queue.addAll(unvisitedNeighbors);
            }
        }
    }

}