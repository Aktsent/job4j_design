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
        T[] rsl = Arrays.copyOf(container, container.length * 2);
        if (container.length == 0) {
            rsl = Arrays.copyOf(container, 8);
        }
        return rsl;
    }

    @Override
    public void add(T value) {
        modCount++;
        if (size == container.length) {
            container = addContainer();
        }
            container[size] = value;
            size += 1;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, container.length);
        T tmp = container[index];
        tmp = newValue;
        return tmp;
    }

    @Override
    public T remove(int index) {
        modCount++;
        Objects.checkIndex(index, container.length);
        T tmp = container[index];
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[container.length - 1] = null;
        return tmp;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, container.length);
        return container[index];
    }

    @Override
    public int size() {
        return container.length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return hasNext();
            }

            @Override
            public T next() {
                return next();
            }

        };
    }
}
