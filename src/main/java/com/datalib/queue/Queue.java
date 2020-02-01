package com.datalib.queue;

public class Queue {
    private Object[] items;
    private int size;
    private int first;
    private int last;
    private QueueLastOperation lastOperation;

    public Queue() {
        this(10);
    }

    public Queue(int size) {
        items = new Object[size];
        this.size = size;
        this.first = 0;
        this.last = 0;
        this.lastOperation = null;
    }

    public void enqueue(Object item) throws QueueIsFullException {
        if (isFull()) {
            throw new QueueIsFullException("This stack is full therefore method 'push' is uncallable");
        }
        items[this.last++] = item;

        if (this.last == this.size) {
            this.last = 0;
        }

        lastOperation = QueueLastOperation.ENQUEUE;
    }

    public Object dequeue() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("This queue is empty therefore method 'dequeue' is uncallable");
        }
        Object item = items[this.first++];
        if (this.first == this.size) {
            this.first = 0;
        }
        lastOperation = QueueLastOperation.DEQUEUE;
        return item;
    }

    private boolean isEmpty() {
        return (this.last == this.first) && (lastOperation != QueueLastOperation.ENQUEUE);
    }

    private boolean isFull() {
        return ((this.first == this.last) && lastOperation == QueueLastOperation.ENQUEUE) || (this.last == this.size && this.first == 0);
    }
}
