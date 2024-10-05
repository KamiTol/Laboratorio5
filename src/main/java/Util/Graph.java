package Util;

public class Graph {
    private Vertex vertices;
    private Edge edges;

    public Graph() {
        this.vertices = null;
        this.edges = null;
    }

    public void addVertex(int id) {
        Vertex newVertex = new Vertex(id);
        newVertex.next = vertices;
        vertices = newVertex;
    }

    public void addEdge(int sourceId, int destinationId) {
        Vertex source = findVertex(sourceId);
        Vertex destination = findVertex(destinationId);

        if (source == null || destination == null) {
            throw new IllegalArgumentException("Source or destination vertex not found");
        }

        Edge newEdge = new Edge(source, destination);
        newEdge.next = edges;
        edges = newEdge;
    }

    public Vertex findVertex(int id) {
        Vertex current = vertices;
        while (current != null) {
            if (current.id == id) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Vertex getNeighbors(int id) {
        Vertex vertex = findVertex(id);
        if (vertex == null) {
            return null;
        }

        Edge currentEdge = edges;
        Vertex neighbors = null;
        while (currentEdge != null) {
            if (currentEdge.source.id == id) {
                Vertex newNeighbor = new Vertex(currentEdge.destination.id);
                newNeighbor.next = neighbors;
                neighbors = newNeighbor;
            }
            currentEdge = currentEdge.next;
        }
        return neighbors;
    }

    public Vertex getVertices() {
        return vertices;
    }

    public Edge getEdges() {
        return edges;
    }
}