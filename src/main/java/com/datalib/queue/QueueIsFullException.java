package com.datalib.queue;

public class QueueIsFullException extends RuntimeException {
    public QueueIsFullException() {
        super();
    }
    public QueueIsFullException(String message) {
        super(message);
    }
}
