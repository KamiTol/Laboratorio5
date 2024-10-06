package Util;

import java.util.HashMap;
import java.util.Map;

public class Graph<T> {
    private Map<T, Vertex<T>> vertices;
    private Edge<T> edges;

    public Graph() {
        this.vertices = new HashMap<>();
        this.edges = null;
    }

    public void addVertex(T id) {
        Vertex<T> newVertex = new Vertex<>(id);
        vertices.put(id, newVertex);
    }

    public void addEdge(T sourceId, T destinationId) {
        Vertex<T> source = vertices.get(sourceId);
        Vertex<T> destination = vertices.get(destinationId);

        if (source == null || destination == null) {
            throw new IllegalArgumentException("Source or destination vertex not found");
        }

        Edge<T> newEdge = new Edge<>(source, destination);
        newEdge.setNext(edges);
        edges = newEdge;
    }

    public Vertex<T> findVertex(T id) {
        return vertices.get(id);
    }

    public Vertex<T> getNeighbors(T id) {
        Vertex<T> vertex = findVertex(id);
        if (vertex == null) {
            return null;
        }

        Edge<T> currentEdge = edges;
        Vertex<T> neighbors = null;
        while (currentEdge != null) {
            if (currentEdge.getSource().getId().equals(id)) {
                Vertex<T> newNeighbor = new Vertex<>(currentEdge.getDestination().getId());
                newNeighbor.setNext(neighbors);
                neighbors = newNeighbor;
            }
            currentEdge = currentEdge.getNext();
        }
        return neighbors;
    }

    public Map<T, Vertex<T>> getVertices() {
        return vertices;
    }

    public Edge<T> getEdges() {
        return edges;
    }
}