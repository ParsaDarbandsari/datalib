package com.datalib.list;

import com.datalib.linkedlist.LinkedList;

public class List<T> {
    private LinkedList<T> list;

    public List() {
        this.list = new LinkedList<>();
    }

    public void add(int index, T item) {
        LinkedList<T> newList = new LinkedList<>();
        newList.addTail(item);
        this.list = newList;
    }

    public void append(T item) {
        this.list.addTail(item);
    }

    public void preAppend() {
        this.preAppend(null);
    }

    public void preAppend(T item) {
        LinkedList<T> newList = new LinkedList<>();
        newList.addHead(item);
        this.list = newList;
    }

    public T get(int index) {
        if (index >= size() || index < 0) {
            throw new ListIndexOutOfBondsException();
        }

        return list.get(index);
    }

    public T removeIndex() {
        return this.removeIndex(-1);
    }

    public T removeIndex(int index) {
        LinkedList<T> newList = new LinkedList<>();

        if (index == -1) {
            return newList.removeTail();
        }

        T item = newList.remove(index);
        this.list = newList;
        return item;
    }

    public void removeItem(T item) {
        LinkedList<T> newList = this.list.Clone();
        if (this.list.size() == 1) {
            if (newList.get(0).equals(item)) {
                newList.remove(0);
                return;
            }
        }

        for (int i = 0; i != this.list.size() - 1; i++) {
            if (newList.get(i).equals(item)) {
                newList.remove(i);
            }
        }

        this.list = newList;
    }

    public int size() {
        return this.list.size();
    }
}
