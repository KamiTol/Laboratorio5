package BFS;

import Util.Graph;
import Util.Vertex;
import Util.Queue;

public class BFS<T> {
    public void bfs(Graph<T> graph, T startId) {
        Vertex<T> startVertex = graph.findVertex(startId);
        if (startVertex == null) {
            throw new IllegalArgumentException("Start vertex not found");
        }

        Queue<T> queue = new Queue<>();
        queue.enqueue(startId);

        while (!queue.isEmpty()) {
            T currentId = queue.dequeue();
            Vertex<T> current = graph.findVertex(currentId);

            Vertex<T> neighbor = graph.getNeighbors(current.getId());
            while (neighbor != null) {
                queue.enqueue(neighbor.getId());
                neighbor = neighbor.getNext();
            }
        }
    }
}
