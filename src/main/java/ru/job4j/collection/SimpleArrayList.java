package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArrayList<T> implements SimpleList<T> {
    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    private T[] addContainer() {
        return Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public void add(T value) {
        if (size == container.length) {
            container = addContainer();
            container[size] = value;
            size += 1;
        }
    }

    @Override
    public T set(int index, T newValue) {

    }

    @Override
    public T remove(int index) {

    }

    @Override
    public T get(int index) {

    }

    @Override
    public int size() {

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {

            }

            @Override
            public T next() {

            }

        };
    }
}
