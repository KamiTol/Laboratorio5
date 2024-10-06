package Util;

public class Vertex<T> {
    private T id;
    private Vertex<T> next;

    public Vertex(T id) {
        this.id = id;
        this.next = null;
    }

    public T getId() {
        return id;
    }

    public Vertex<T> getNext() {
        return next;
    }

    public void setNext(Vertex<T> next) {
        this.next = next;
    }
}