package ru.job4j.collection;

import java.util.*;

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
        T tmp = get(index);
        container[index] = newValue;
        return tmp;
    }

    @Override
    public T remove(int index) {
        modCount++;
        T tmp = get(index);
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[container.length - 1] = null;
        size--;
        return tmp;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int count = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return count < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[count++];
            }
        };
    }
}
