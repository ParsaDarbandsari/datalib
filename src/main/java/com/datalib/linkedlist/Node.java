package com.datalib.linkedlist;

// Class access is package-private
class Node<T> {
    private T value;
    private Node<T> next;


    public Node() {
        this(null, null);
    }

    public Node(T value) {
        this(value, null);
    }

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T value() {
        return this.value;
    }

    public Node<T> next() {
        return this.next;
    }

    public void setNext(Node<T> node) {
        this.next = node;
    }
}
