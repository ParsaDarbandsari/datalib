package com.datalib.linkedlist;


public class LinkedList<T> implements Cloneable {

    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    public Node<T> getHead() {
        return head;
    }

    private Node<T> getTail() {
        Node<T> n = getHead();

        if (n == null) {
            return null;
        }
        while (n.next() != null) {
            n = n.next();
        }
        return n;
    }

    private Node<T> secondToLast() {
        Node<T> n = getHead();

        if (n == null || n.next() == null) {
            throw new InvalidOperationException();
        }

        while (n.next().next() != null) {
            n = n.next();
        }

        return n;
    }

    public int size() {
        Node<T> n = getHead();
        int size = 0;

        while (n != null) {
            size++;
            n = n.next();
        }

        return size;
    }



    public void addTail(T newTail) {
        Node<T> tail = getTail();

        if (tail == null) {
            this.head = new Node<>(newTail);
            return;
        }
        tail.setNext(new Node<>(newTail));
    }

    public T removeTail() throws LinkedListIsEmptyException {
        if (isEmpty()) {
            throw new LinkedListIsEmptyException();
        }

        if (size() == 1) {
            return removeHead();
        }

        Node<T> tail = getTail();
        Node<T> secondToLast = secondToLast();

        secondToLast.setNext(null);
        return tail.value();
    }

    public void addHead(T newHead) {
        Node<T> Head = new Node<>(newHead, getHead());
        Head.setNext(this.head);
        this.head = Head;
    }

    public T removeHead() {
        Node<T> oldHead = this.head;
        this.head = this.head.next();

        return oldHead.value();
    }

    public Node<T> getNode(int index) {
        Node<T> n = getHead();

        if (index > this.size() - 1) {
            throw new LinkedListIndexOutOfBondsException();
        }

        for (int j = 0; j != index; j++) {
            n = n.next();
        }


        return n;
    }

    public T get(int index) {
        return getNode(index).value();
    }

    public T remove() {
        return this.remove(-1);
    }

    public T remove(int index) {
        if (index == -1) {
            return this.removeTail();
        }

        if (index == 0) {
            return this.removeHead();
        }

        Node<T> beforeTarget = getNode(index - 1);
        Node<T> target = getNode(index);

        beforeTarget.setNext(target.next());

        return target.value();
    }

    public void addByIndex(int index) {
        this.addByIndex(index, null);
    }

    public void addByIndex(int index, T item) {
        if (index == -1) {
            addTail(item);
            return;
        }

        Node<T> beforeTarget = getNode(index - 1);
        Node<T> afterTarget = getNode(index);
        Node<T> target = new Node<>(item, afterTarget);
        beforeTarget.setNext(target);
    }

    public boolean isEmpty() {
        return (getHead() == null);
    }


    public LinkedList<T> Clone(){
        LinkedList<T> New = new LinkedList<>();
        Node<T> n = this.head;

        while (n != null) {
            New.addTail(n.value());
            n = n.next();
        }

        return New;
    }
}
