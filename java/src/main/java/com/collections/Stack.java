package com.collections;

import java.util.EmptyStackException;

public class Stack<E> {

    private static final int DEFAULT_INITIAL_SIZE = 10;

    private Object[] elems;
    private int nextIdx;

    public Stack() {
        this(DEFAULT_INITIAL_SIZE);
    }

    public Stack(int initialSize) {
        if (initialSize <= 0) {
            throw new IllegalArgumentException("Invalid initialSize for Stack: " + initialSize);
        }
        elems = new Object[initialSize];
        nextIdx = 0;
    }

    public void push(E elem) {
        if (nextIdx == elems.length) {
            enlarge();
        }
        elems[nextIdx++] = elem;
    }

    public E pop() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        @SuppressWarnings("Elements are only added to the array through the " +
                "push method, which receives an E, and the " +
                "elems array is never exposed outside of this class.")
        E elem = (E) elems[--nextIdx];
        if (nextIdx == elems.length / 4) {
            reduce();
        }
        return elem;
    }

    public E peek() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        @SuppressWarnings("Elements are only added to the array through the " +
                "push method, which receives an E, and the " +
                "elems array is never exposed outside of this class.")
        E elem = (E) elems[nextIdx - 1];
        return elem;
    }

    public int size() {
        return nextIdx;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void enlarge() {
        resizeElems(elems.length * 2);
    }

    private void reduce() {
        resizeElems(elems.length / 2);
    }

    private void resizeElems(int newSize) {
        Object[] newElems = new Object[newSize];
        for (int i = 0; i < nextIdx; i++) {
            newElems[i] = elems[i];
        }
        elems = newElems;
    }

}