package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import java.util.EmptyStackException;

public class Stack {
    private ImmutableLinkedList list = new ImmutableLinkedList();

    public void push(Object e) {
        list = list.addFirst(e);
    }

    public Object pop() throws EmptyStackException {
        Object elm = list.getFirst();
        list = list.removeFirst();
        return elm;
    }

    public Object peek() throws EmptyStackException {
        return list.getFirst();
    }
}