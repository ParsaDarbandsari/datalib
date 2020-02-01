package com.datalib.stack;

public class Stack<T> {
    private T[] items;
    private int index;
    private int size;

    public Stack() {
        this(10);
    }

    public Stack(int size) {
        items = (T[]) new Object[size];
        index = 0;
        this.size = size;
    }

    public void push(T item) {
        if (index == size) {
            throw new StackIsFullException("This stack is full therefore method 'push' is uncallable'");
        }
        items[index] = item;
        index++;
    }

    public T pop() {
        if (index == 0) {
            throw new StackIsEmptyException("This stack is empty therefore method 'pop' is uncallable");
        }
        return items[--index];
    }

    public T top() {
        return this.items[index - 1];
    }
}
