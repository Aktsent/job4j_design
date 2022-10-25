package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements LinkedList<E>  {
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
        Node<E> n = first;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n.getElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            Node<E> n = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return n != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> rsl = n;
                n = n.next;
                return rsl.element;
            }
        };
    }
}