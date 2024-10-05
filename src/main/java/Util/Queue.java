package Util;

import Util.LL.LinkedList;
import Util.LL.Node;

public class Queue {
    private LinkedList list;

    public Queue() {
        this.list = new LinkedList();
    }

    public void enqueue(int data) {
        list.add(data);
    }

    public int dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        Node head = list.getHead();
        int data = head.data;
        list.head = head.next;
        return data;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}