package ua.edu.ucu.collections.immutable;

public class Node {
    private Node previous;
    private Node next;
    private Object value;

    public Node() {
        this.next = null;
        this.value = null;
        this.previous = null;
    }

    @Override
    public String toString() {
        return value.toString();
    }


    public Node getPrevious() {
        return this.previous;
    }

    public void setPrevious(Node prev) {
        this.previous = prev;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object val) {
        this.value = val;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node nextNode) {
        this.next = nextNode;
    }
}

