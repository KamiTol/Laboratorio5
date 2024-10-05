package Util;

import Util.LL.LinkedList;
import Util.LL.Node;

public class Stack {
    private LinkedList list;

    public Stack() {
        this.list = new LinkedList();
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = list.getHead();
        list.head = newNode;
    }

    public int pop() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
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