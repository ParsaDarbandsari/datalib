package com.datalib.linkedlist;

public class LinkedListIsEmptyException extends RuntimeException {
    public LinkedListIsEmptyException() {
        super();
    }

    public LinkedListIsEmptyException(String message) {
        super(message);
    }
}
