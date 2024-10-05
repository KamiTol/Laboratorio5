package Util;

class Edge {
    Vertex source;
    Vertex destination;
    Edge next;

    Edge(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;
        this.next = null;
    }
}
