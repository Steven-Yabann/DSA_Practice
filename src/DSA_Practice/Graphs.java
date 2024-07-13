package DSA_Practice;

import java.util.*;

public class Graphs {

    // Inner class to keep track of edges
    private class Edge {
        char src, dest;
        int weight;
    }

    // Number of vertices and edges
    private final int vertices;
    private final int edges;
    private static int edgeCount; // To keep track of the current number of edges

    // Array to store all edges
    private static Edge[] edge;

    public Graphs(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        edgeCount = 0;

        // Initialize the edge array
        edge = new Edge[edges];
        for (int i = 0; i < edges; i++) {
            // Each element of the edge array is an object of Edge type
            edge[i] = new Edge();
        }
    }

    // Method to add an edge to the graph
    public void addEdge(char src, char dest, int weight) {
        if (edgeCount < edges) {
            edge[edgeCount].src = src;
            edge[edgeCount].dest = dest;
            edge[edgeCount].weight = weight;
            edgeCount++;
        } else {
            System.out.println("Cannot add more edges, the graph is full.");
        }
    }


    // Method to print all edges in the graph
    public void printGraph() {
        for (int i = 0; i < edgeCount; i++) {
            System.out.println(edge[i].src + " - " + edge[i].weight + " - " + edge[i].dest);
        }
    }

    // Method to perform Depth-First Search (DFS)
    public static void DFS(char start) {
        List<Character> visited = new ArrayList<>();
        depthFirstSearch(start, visited);
    }

    private static void depthFirstSearch(char vertex, List<Character> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (int i = 0; i < edgeCount; i++) {
            if (edge[i].src == vertex && !visited.contains(edge[i].dest)) {
                depthFirstSearch(edge[i].dest, visited);
            } else if (edge[i].dest == vertex && !visited.contains(edge[i].src)) {
                depthFirstSearch(edge[i].src, visited);
            }
        }
    }


    // Method to perform Depth-Limited Search (DLS)
    public static void DLS(char start, int limit) {
        List<Character> visited = new ArrayList<>();
        depthFirstSearch(start, limit, visited);
    }

    private static void depthFirstSearch(char vertex, int limit, List<Character> visited) {
        if (limit > 0) {
            limit--;
            visited.add(vertex);
            System.out.print(vertex + " ");

            for (int i = 0; i < edgeCount; i++) {
                if (edge[i].src == vertex && !visited.contains(edge[i].dest)) {
                    depthFirstSearch(edge[i].dest, limit, visited);
                } else if (edge[i].dest == vertex && !visited.contains(edge[i].src)) {
                    depthFirstSearch(edge[i].src, limit, visited);
                }
            }
        }
    }



    public static void main(String[] args) {
        // Create an object of Graph class
        int noVertices = 6;
        int noEdges = 9;
        Graphs g = new Graphs(noVertices, noEdges);

        // Add edges
        g.addEdge('A', 'B', 5); // edge 1---2
        g.addEdge('A', 'C', 6); // edge 1---3
        g.addEdge('A', 'D', 1); // edge 1---4
        g.addEdge('B', 'D', 9); // edge 2---4
        g.addEdge('B', 'E', 5); // edge 2---5
        g.addEdge('C', 'D', 3); // edge 3---4
        g.addEdge('C', 'E', 6); // edge 3---5
        g.addEdge('D', 'E', 2); // edge 4---5
        g.addEdge('C', 'F', 8); // edge 3---6

        // Print the graph
        g.printGraph();

        // Perform DFS
        System.out.println("Depth First Search operation being performed: ");
        DFS('A');

        // Perform DLS
        System.out.println("\nDepth Limited Search operation being performed: ");
        DLS('A', 3);
    }
}