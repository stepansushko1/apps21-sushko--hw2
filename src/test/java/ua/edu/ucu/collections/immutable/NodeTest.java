package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    Node node1;
    Node node2;

    @Before
    public void setUp() {
        node1 = new Node();
        node1.setValue(99);
        node2 = new Node();
        node2.setValue(100);
        node2.setPrevious(node1);
        node1.setNext(node2);
    }

    @Test
    public void testToString() {
        assertEquals("99", node1.toString());
        assertEquals("100", node2.toString());
    }

    @Test
    public void getPrevious() {
        assertEquals(node1, node2.getPrevious());
        assertNull(node1.getPrevious());
    }

    @Test
    public void getNext() {
        assertEquals(node2, node1.getNext());
        assertNull(node2.getNext());
    }

    @Test
    public void getValue() {
        assertEquals(99, node1.getValue());
        assertEquals(100, node2.getValue());
    }

}