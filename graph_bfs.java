import java.util.*;
class A {
    private int n;
    ArrayList<ArrayList<Integer>> adj;

    public A(int n) {
        this.n = n;
        this.adj = new ArrayList<>(n);


        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        if (u >= 0 && v < n && v >= 0 && u < n) {
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }

    public void breadthFirstSearch(int startVertex) {
        boolean[] visited = new boolean[n]; // Keeps track of visited vertices
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS traversal

        visited[startVertex] = true; // Mark the start vertex as visited
        queue.offer(startVertex); // Add the start vertex to the queue

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll(); // Get the next vertex from the queue
            System.out.print(currentVertex + " "); // Process the current vertex (in this case, print it)

            ArrayList<Integer> neighbors = adj.get(currentVertex); // Get the neighbors of the current vertex
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) { // Check if the neighbor has not been visited
                    visited[neighbor] = true; // Mark the neighbor as visited
                    queue.offer(neighbor); // Add the neighbor to the queue for further exploration
                }
            }
        }
    }


}

public class graph_bfs {
    public static void main(String[] args) {
        A graph = new A(6);
        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);

        int startVertex=0;
        System.out.println();
        System.out.println("BFS traversal starting from vertex " + startVertex + ": ");
        graph.breadthFirstSearch(startVertex);


    }
}
