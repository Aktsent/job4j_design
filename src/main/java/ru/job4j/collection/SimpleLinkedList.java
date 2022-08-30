package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements LinkedList<E>  {
    private Node<E> node;
    private int size;
    private Node<E> first;
    private Node<E> last;
    private int modCount;

    @Override
    public void add(E value) {
        final Node<E> lst = last;
        final Node<E> newLast = new Node<>(lst, value, null);
        last = newLast;
        if (lst == null) {
            first = newLast;
        } else {
            lst.next = newLast;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        for (int i = 1; i < size; i++) {
            if (i == index) {
                node.getElement();
                break;
            }
        }
        return node.getElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (node.next == null) {
                    break;
                }
                return hasNext();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return node.next.element;
            }
        };
    }
}