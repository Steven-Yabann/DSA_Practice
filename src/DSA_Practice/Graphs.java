package DSA_Practice;

public class Graphs {

    // inner class to track edges
    private class Edge {
        char src, dest;
    }

    private int vertices, edges; // number of edges and vertices
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
            edge[edgeCount].dest = dest;
            edgeCount++;
        } else {
            System.out.println("Cannot add any more items, the static graph is full");
        }
    }

    // printing method
    public void printGraph() {
        for (int i = 0; i < edgeCount; i++) {
            System.out.println(edge[i].src + " -- " + edge[i].dest);
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

    }


}







