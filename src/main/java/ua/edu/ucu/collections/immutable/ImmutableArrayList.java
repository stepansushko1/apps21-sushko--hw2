package ua.edu.ucu.collections.immutable;

import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] arr;
    private int elementsAmount = 0;

    public ImmutableArrayList(Object[] elements) {
        arr = new Object[elements.length];
        this.elementsAmount = elements.length;
        System.arraycopy(elements, 0, arr, 0, elements.length);
    }

    public ImmutableArrayList() {
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < elementsAmount; i++) {
            output.append(arr[i]);
        }
        return output.toString();
    }

    @Override
    public ImmutableList add(Object e) {
        return add(elementsAmount, e);
    }

    @Override
    public ImmutableList add(int index, Object e)
            throws IndexOutOfBoundsException {
        return addAll(index, new Object[] {e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(elementsAmount, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c)
            throws IndexOutOfBoundsException {
        if ((index > elementsAmount + 1) || (index < 0)) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArr = new Object[size() + c.length];
        System.arraycopy(arr, 0, newArr, 0, index);
        System.arraycopy(c, 0, newArr, index, index + c.length - index);

        if (elementsAmount + c.length - (index + c.length) >= 0){
            System.arraycopy(arr, index + c.length - c.length, newArr, index +
                    c.length, elementsAmount + c.length - (index + c.length));
        }

        ImmutableArrayList res = new ImmutableArrayList(newArr);
        res.elementsAmount = elementsAmount + c.length;
        return res;
    }

    @Override
    public Object get(int index) {
        if ((index < 0) || (index >= elementsAmount)) {
            throw new IndexOutOfBoundsException();
        }

        return arr[index];
    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
@Override
public ImmutableList remove(int index) throws IndexOutOfBoundsException {
    if ((index > elementsAmount) || (index < 0)) {
        throw new IndexOutOfBoundsException();
    }

    Object[] newArr = new Object[elementsAmount];
    System.arraycopy(arr, 0, newArr, 0, index);

    if (elementsAmount - (index + 1) >= 0) {
        System.arraycopy(arr, index + 1, newArr, index + 1 - 1,
                elementsAmount - (index + 1));
    }

    ImmutableArrayList res = new ImmutableArrayList(newArr);
    res.elementsAmount = elementsAmount - 1;
    return  res;
}
    @Override
    public ImmutableList set(int index, Object e) {

        if (index < 0 || index > elementsAmount) {
            throw new IndexOutOfBoundsException();
        }

        Object[] newArr = toArray();
        newArr[index] = e;
        return new ImmutableArrayList(newArr);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < elementsAmount; i++) {
            if (Objects.equals(arr[i], e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return elementsAmount;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return elementsAmount == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr = new Object[elementsAmount];
        System.arraycopy(arr, 0, newArr, 0, elementsAmount);
        return newArr;
    }
}
