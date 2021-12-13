package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    ImmutableLinkedList list;

    @Before
    public void setUp() {
        list = new ImmutableLinkedList(new Object[]{1, 6, 5, 8});
    }

    @Test
    public void testAdd() {
        ImmutableLinkedList extended = (ImmutableLinkedList) list.add(4);
        assertArrayEquals(extended.toArray(), new Object[]{1, 6, 5, 8, 4});
    }

    @Test
    public void testAddIndex() {
        ImmutableLinkedList extended = (ImmutableLinkedList) list.add(1,4);
        assertArrayEquals(extended.toArray(), new Object[]{1, 4, 6, 5, 8});
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddInvalidIndexRight() {
        list.add(9,4);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddInvalidIndexLeft() {
        list.add(-1,4);
    }

    @Test
    public void testAddAll() {
        ImmutableLinkedList extended = (ImmutableLinkedList) list.addAll(new Object[]{1, 2, 3});
        assertArrayEquals(extended.toArray(), new Object[]{1, 6, 5, 8, 1, 2, 3});
    }

    @Test
    public void testAddAllIndex() {
        ImmutableList extended = new ImmutableLinkedList(
                new Object[]{1, 6, 5, 8}).addAll(0, new Object[]{1, 2, 3});
        assertArrayEquals(extended.toArray(), new Object[]{1, 2, 3, 1, 6, 5, 8});
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddAllInvalidIndexRight() {
        list.addAll(9,new Object[]{1, 2, 3});
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testAddAllInvalidIndexLeft() {
        list.addAll(-1, new Object[]{1, 2, 3});
    }

    @Test
    public void testGet() {
        assertEquals(1,list.get(0));
        assertEquals(6,list.get(1));
        assertEquals(5,list.get(2));
        assertEquals(8,list.get(3));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetInvalidIndexRight() {
        list.get(5);
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetInvalidIndexLeft() {
        list.get(-1);
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList elems = (ImmutableLinkedList) list.remove(0);
        assertArrayEquals(elems.toArray(), new Object[]{6, 5, 8});
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveInvalidIndexRight() {
        list.remove(5);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveInvalidIndexLeft() {
        list.remove(-1);
    }

    @Test
    public void testSet() {
        ImmutableLinkedList newList = (ImmutableLinkedList) list.set(2, -1);
        assertArrayEquals(newList.toArray(), new Object[]{1, 6, -1, 8});
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetInvalidIndexRight() {
        list.set(9, -1);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetInvalidIndexLeft() {
        list.set(-1, -1);
    }

    @Test
    public void testIndexOf() {
        assertEquals(0, list.indexOf(1));
        assertEquals(1, list.indexOf(6));
        assertEquals(2, list.indexOf(5));
        assertEquals(3, list.indexOf(8));
        assertEquals(-1, list.indexOf(9));
    }

    @Test
    public void testSize() {
        assertEquals(4, list.size());
    }

    @Test
    public void testClear() {
        ImmutableLinkedList cleared = (ImmutableLinkedList) list.clear();
        assertEquals(0, cleared.size());
        assertArrayEquals(new Object[] {}, cleared.toArray());
    }

    @Test
    public void testIsEmptyNotEmpty() {
        assertFalse(list.isEmpty());
    }

    @Test
    public void testIsEmptyEmpty() {
        ImmutableArrayList emptyList = new ImmutableArrayList();
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(list.toArray(), new Object[]{1, 6, 5, 8});
    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList expected = new ImmutableLinkedList(
                new Object[]{1, 6, 5, 8}).addFirst(7);
        Object[] actual = new Object[]{7, 1, 6, 5, 8};
        assertArrayEquals(expected.toArray(), actual);
    }

    @Test
    public void addLast() {
        ImmutableLinkedList expected = (ImmutableLinkedList) list.addLast(7);
        Object[] actual = new Object[]{1, 6, 5, 8, 7};
        assertArrayEquals(expected.toArray(), actual);
    }

    @Test
    public void testGetHead() {
        assertEquals(1, list.getHead().getValue());
    }

    @Test
    public void getTail() {
        assertEquals(8, list.getTail().getValue());
    }

    @Test
    public void testGetFirst() {
        assertEquals(1, list.getFirst());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetFirstEmpty() {
        ImmutableLinkedList empty = new ImmutableLinkedList();
        empty.getFirst();
    }

    @Test
    public void testGetLast() {
        assertEquals(8, list.getLast());
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testGetLastEmpty() {
        ImmutableLinkedList empty = new ImmutableLinkedList();
        empty.getLast();
    }

    @Test
    public void removeFirst() {
        ImmutableLinkedList expected = (ImmutableLinkedList) list.removeFirst();
        assertArrayEquals(expected.toArray(), new Object[]{6, 5, 8});
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveFirstEmpty() {
        ImmutableLinkedList empty = new ImmutableLinkedList();
        empty.removeFirst();
    }

    @Test
    public void removeLast() {
        ImmutableLinkedList expected = (ImmutableLinkedList) list.removeLast();
        assertArrayEquals(expected.toArray(), new Object[]{1, 6, 5});
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveLastEmpty() {
        ImmutableLinkedList empty = new ImmutableLinkedList();
        empty.removeLast();
    }

}
