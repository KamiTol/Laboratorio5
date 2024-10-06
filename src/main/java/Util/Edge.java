package Util;

public class Edge<T> {
    private Vertex<T> source;
    private Vertex<T> destination;
    private Edge<T> next;

    public Edge(Vertex<T> source, Vertex<T> destination) {
        this.source = source;
        this.destination = destination;
        this.next = null;
    }

    public Vertex<T> getSource() {
        return source;
    }

    public Vertex<T> getDestination() {
        return destination;
    }

    public Edge<T> getNext() {
        return next;
    }

    public void setNext(Edge<T> next) {
        this.next = next;
    }
}