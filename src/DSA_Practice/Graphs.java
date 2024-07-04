package DSA_Practice;
import java.util.*;

public class Graphs {
    Random random = new Random();
    // inner class to track edges
    private class Edge {
        char src, dest;
        int weight;
    }
    private int vertices, edges; // number of vertices, edges
    private int edgeCount;      // track number of edges as we build the graph
    private Edge[] edge;
    // constructor
    public Graphs(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.edgeCount = 0;

        // init the edge array
        edge = new Edge[edges];
        for (int i = 0; i < edges; i++) {
            edge[i] = new Edge();
        }
    }
    public void addEdge(char src, char dest) {
        if (edgeCount < edges) {
            edge[edgeCount].src = src;
            edge[edgeCount].weight = random.nextInt(10);
            edge[edgeCount].dest = dest;
            edgeCount++;
        } else {
            System.out.println("Cannot add any more items, the static graph is full");
        }
    }
    // printing method
    public void printGraph() {
        for (int i = 0; i < edgeCount; i++) {
            System.out.println(edge[i].src + " -- " + edge[i].weight + " -- " + edge[i].dest);
        }
    }
    public void DFS(char start){
        Set<Character> visited = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        stack.push(start);

        while(!stack.isEmpty()) {
            char vertex = stack.pop();

            if(!visited.contains(vertex)){
                visited.add(vertex);
                System.out.println(vertex + " ");

                for(int i = 0; i < edgeCount; i++){
                    if(edge[i].src == vertex && !visited.contains(edge[i].dest)){
                        stack.push(edge[i].dest);
                    }else if(edge[i].dest == vertex && !visited.contains(edge[i].src)){
                        stack.push(edge[i].src);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int noVertices = 6;
        int noEdges = 9;
        Graphs g = new Graphs(noVertices, noEdges);
        // adding edges
        g.addEdge('A', 'B');
        g.addEdge('A', 'C');
        g.addEdge('A', 'D');
        g.addEdge('B', 'D');
        g.addEdge('B', 'E');
        g.addEdge('C', 'D');
        g.addEdge('C', 'E');
        g.addEdge('C', 'F');
        g.addEdge('D', 'E');

        g.printGraph();
        System.out.println("Depth First Traversal starting from vertex A:");
        g.DFS('A');
    }
}

