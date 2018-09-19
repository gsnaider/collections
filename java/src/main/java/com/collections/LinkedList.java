package com.collections;

import java.util.*;

public final class LinkedList<E> {

    private int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        int currentPos = 0;
        Node<E> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(currentNode.elem, o)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public boolean add(E e) {
        Node<E> node =  new Node<>(e, null);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else {
            tail.next = node;
            tail = node;
        }
        return true;
    }

    public void add(int i, E e) {
        if (i < 0 || i > size) {
            throw new IllegalArgumentException();
        }
        if (i == size) {
            add(e);
            return;
        }
        int currentPos = 0;
        Node<E> currentNode = head;
        while (currentPos < i - 1) {
            currentNode = currentNode.next;
            currentPos++;
        }
        Node<E> nodeToInsert =  new Node<>(e, currentNode.next);
        currentNode.next = nodeToInsert;
        size++;

    }

    public boolean remove(Object o) {
        return false;
    }

    public E remove(int i) {
        return null;
    }

    public void clear() {

    }

    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IllegalArgumentException();
        }
        int currentPos = 0;
        Node<E> currentNode = head;
        while (currentPos < i) {
            currentNode = currentNode.next;
            currentPos++;
        }
        return currentNode.elem;
    }

    public E set(int i, E e) {
        return null;
    }

    private static class Node<E> {

        private E elem;

        private Node<E> next;

        private Node(E elem, Node<E> next) {
            this.elem = elem;
            this.next = next;
        }

    }
}