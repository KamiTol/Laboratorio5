package DFS;

import Util.Graph;
import Util.Vertex;
import Util.Stack;

public class DFS {
    public void dfs(Graph graph, int startId) {
        Vertex startVertex = graph.findVertex(startId);
        if (startVertex == null) {
            throw new IllegalArgumentException("Start vertex not found");
        }

        Stack stack = new Stack();
        stack.push(startId);

        while (!stack.isEmpty()) {
            int currentId = stack.pop();
            Vertex current = graph.findVertex(currentId);
            System.out.println("Visited vertex: " + current.id);

            Vertex neighbor = graph.getNeighbors(current.id);
            while (neighbor != null) {
                stack.push(neighbor.id);
                neighbor = neighbor.next;
            }
        }
    }
}