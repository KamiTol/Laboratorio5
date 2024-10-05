package BFS;

import Util.Graph;
import Util.Vertex;
import Util.Queue;

public class BFS {
    public void bfs(Graph graph, int startId) {
        Vertex startVertex = graph.findVertex(startId);
        if (startVertex == null) {
            throw new IllegalArgumentException("Start vertex not found");
        }

        Queue queue = new Queue();
        queue.enqueue(startId);

        while (!queue.isEmpty()) {
            int currentId = queue.dequeue();
            Vertex current = graph.findVertex(currentId);

            Vertex neighbor = graph.getNeighbors(current.id);
            while (neighbor != null) {
                queue.enqueue(neighbor.id);
                neighbor = neighbor.next;
            }
        }
    }
}
