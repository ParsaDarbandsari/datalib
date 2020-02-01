package com.datalib.queue;

public class QueueIsEmptyException extends RuntimeException {
    public QueueIsEmptyException() {
        super();
    }
    public QueueIsEmptyException(String message) {
        super(message);
    }
}
