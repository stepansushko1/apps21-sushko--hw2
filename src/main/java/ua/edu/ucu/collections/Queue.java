package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import java.util.EmptyStackException;

public class Queue {
    private ImmutableLinkedList list = new ImmutableLinkedList();


    public Object peek() throws EmptyStackException {
        return list.getFirst();
    }

    public Object dequeue() throws EmptyStackException {
        Object elm = list.getFirst();
        list = list.removeFirst();
        return elm;
    }

    public void enqueue(Object e) {
        list = list.addLast(e);
    }
}