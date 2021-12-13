package ua.edu.ucu.collections.immutable;


import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest{
    private ImmutableArrayList testArr, testArr2;
    private Object[] arr =  {1, 2, 3};

    @Test
    public void testTestToString() {
        testArr = new ImmutableArrayList(arr);
        assertEquals("123", testArr.toString());
    }


    @Test
    public void testAdd() {
        testArr = new ImmutableArrayList(arr);
        testArr2 = (ImmutableArrayList) testArr.add(4);
        assertEquals("1234", testArr2.toString());
        assertEquals("123", testArr.toString());
        testArr2 = (ImmutableArrayList) testArr.add(0, 4);
        assertEquals("4123", testArr2.toString());
        assertEquals("123", testArr.toString());

        testArr2 = (ImmutableArrayList) testArr.add(2, 4);
        assertEquals("1243", testArr2.toString());
        assertEquals("123", testArr.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddFail() {
        testArr = new ImmutableArrayList(arr);
        testArr2 = (ImmutableArrayList) testArr.add(100, 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddFail2() {
        testArr = new ImmutableArrayList(arr);
        testArr2 = (ImmutableArrayList) testArr.add(-1, 4);
    }

    @Test
    public void testAddAll() {
        testArr = new ImmutableArrayList(arr);
        testArr2 = (ImmutableArrayList) testArr.addAll(arr);
        assertEquals("123123", testArr2.toString());
        assertEquals("123", testArr.toString());
        testArr2 = (ImmutableArrayList) testArr.addAll(0, arr);
        assertEquals("123123", testArr2.toString());
        assertEquals("123", testArr.toString());

        testArr2 = (ImmutableArrayList) testArr.addAll(2, arr);
        assertEquals("121233", testArr2.toString());
        assertEquals("123", testArr.toString());

        testArr2 = (ImmutableArrayList) testArr.addAll(
                0, new Object[] {9, 8, 7, 6, 5, 4, 3, 2, 1});
        assertEquals("987654321123", testArr2.toString());
        assertEquals("123", testArr.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllFail() {
        testArr = new ImmutableArrayList(arr);
        testArr2 = (ImmutableArrayList) testArr.add(100, arr);
    }


    @Test
    public void testGet() {
        testArr = new ImmutableArrayList(arr);
        assertEquals(1, testArr.get(0));

        testArr = new ImmutableArrayList(arr);
        assertEquals(3, testArr.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetFail(){
        testArr = new ImmutableArrayList(arr);
        testArr.get(100);

    }

    @Test
    public void testRemove() {
        testArr = new ImmutableArrayList(arr);
        testArr2 = (ImmutableArrayList) testArr.remove(0);
        assertEquals("23", testArr2.toString());
        assertEquals("123", testArr.toString());

        testArr2 = (ImmutableArrayList) testArr.remove(2);
        assertEquals("12", testArr2.toString());
        assertEquals("123", testArr.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFail(){
        testArr = new ImmutableArrayList(arr);
        testArr.remove(100);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFail2(){
        testArr = new ImmutableArrayList(arr);
        testArr.remove(-10);

    }

    @Test
    public void testSet() {
        testArr = new ImmutableArrayList(arr);
        testArr2 = (ImmutableArrayList) testArr.set(0, 100);
        assertEquals("10023", testArr2.toString());
        assertEquals("123", testArr.toString());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetFail(){
        testArr = new ImmutableArrayList(arr);
        testArr.set(100, 100);

    }

    @Test
    public void testIndexOf() {
        testArr = new ImmutableArrayList(arr);
        assertEquals(0, testArr.indexOf(1));
        assertEquals(-1, testArr.indexOf(30));

    }

    @Test
    public void testSize() {
        testArr = new ImmutableArrayList(arr);
        assertEquals(3, testArr.size());

    }

    @Test
    public void testClear() {
        testArr = new ImmutableArrayList(arr);
        testArr2 = (ImmutableArrayList) testArr.clear();
        assertEquals(0, testArr2.size());
        assertEquals(3, testArr.size());
        assertEquals("123", testArr.toString());

    }

    @Test
    public void testToArray() {
        testArr = new ImmutableArrayList(arr);
        Object[] arr2 = testArr.toArray();
        assertArrayEquals(arr, arr2);
    }

}



