package BFS;

import Util.Graph;
import Util.Vertex;
import Util.Queue;

public class BFS1<Integer> {
    public void bfs(Graph<Integer> graph, Integer startId) {
        Vertex<Integer> startVertex = graph.findVertex(startId);
        if (startVertex == null) {
            throw new IllegalArgumentException("Start vertex not found");
        }

        Queue<Integer> queue = new Queue<>();
        queue.enqueue(startId);

        while (!queue.isEmpty()) {
            Integer currentId = queue.dequeue();
            Vertex<Integer> current = graph.findVertex(currentId);

            Vertex<Integer> neighbor = graph.getNeighbors(current.getId());
            while (neighbor != null) {
                queue.enqueue(neighbor.getId());
                neighbor = neighbor.getNext();
            }
        }
    }
}