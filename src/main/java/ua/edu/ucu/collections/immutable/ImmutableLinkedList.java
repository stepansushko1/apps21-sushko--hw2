package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private Node tail;
    private int length;

    public ImmutableLinkedList(Object[] elements) {
        if (elements.length == 0) {
            this.head = null;
            this.tail = null;
            this.length = 0;
            return;
        }
        this.head = new Node();
        this.head.setValue(elements[0]);
        this.head.setNext(null);
        this.length = elements.length;

        Node current = this.head;

        for (int i = 1; i < elements.length; i++) {
            Node node = new Node();
            node.setNext(null);
            node.setValue(elements[i]);
            current.setNext(node);
            current = node;

        }

        this.tail = current;
    }

    public ImmutableLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(size(), e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if ((index < 0 )|| (index > size())) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArr = new Object[size() + c.length];
        Node current = this.head;
        int counter = 0;
        int i = 0;

        //copy previous elems
        while (counter < index) {
            newArr[counter++] = current.getValue();
            current = current.getNext();
        }

        //insert new elems
        while (counter < c.length + index) {
            newArr[counter++] = c[i++];
        }

        while (current != null) {
            newArr[counter++] = current.getValue();
            current = current.getNext();
        }

        return new ImmutableLinkedList(newArr);
    }

    @Override
    public Object get(int index) {
        if ((index < 0 ) || (index >= size())) {
            throw new IndexOutOfBoundsException();
        }
        Node curr = this.head;
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }

        return curr.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        if ((index < 0 )|| (index >= size())) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArr = new Object[size() - 1];
        Node curr = this.head;

        for (int i = 0; i < size() - 1; i++) {
            if (i == index) {
                curr = curr.getNext();
            }
            newArr[i] = curr.getValue();
            curr = curr.getNext();
        }

        return new ImmutableLinkedList(newArr);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArr = new Object[size()];
        Node current = this.head;

        for (int i = 0; i < size(); i++) {
            if (i == index) {
                newArr[i] = e;
            } else {
                newArr[i] = current.getValue();
            }
            current = current.getNext();
        }

        return new ImmutableLinkedList(newArr);
    }

    @Override
    public int indexOf(Object e) {
        Node curr = this.head;
        for (int i = 0; i < size(); i++) {
            if (curr.getValue() == e) {
                return i;
            }
            curr = curr.getNext();
        }

        return -1;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr = new Object[size()];
        Node curr = this.head;

        for (int i = 0; i < size(); i++) {
            newArr[i] = curr.getValue();
            curr = curr.getNext();
        }
        return newArr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(e);
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public Object getFirst() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return this.head.getValue();
    }

    public Object getLast() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return this.tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return (ImmutableLinkedList) remove(size() - 1);
    }
}
