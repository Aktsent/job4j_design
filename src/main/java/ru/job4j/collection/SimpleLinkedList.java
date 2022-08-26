package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements LinkedList<E>  {
    private final Iterator<E> cursor = Collections.emptyIterator();
    Node<E> node;
    int size;
    Node<E> first;
    Node<E> last;
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
        return node.getElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int count = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return cursor.hasNext();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return cursor.next();
            }
        };
    }
}