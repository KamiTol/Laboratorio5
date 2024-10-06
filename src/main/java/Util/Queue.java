package Util;

import Util.LL.LinkedList;
import Util.LL.Node;

public class Queue<T> {
    private LinkedList<T> list;

    public Queue() {
        this.list = new LinkedList<>();
    }

    public void enqueue(T data) {
        list.add(data);
    }

    public T dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Node<T> head = list.getHead();
        T data = head.getData();
        list.setHead(head.getNext());
        return data;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}