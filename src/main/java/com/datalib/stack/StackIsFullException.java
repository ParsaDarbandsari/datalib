package com.datalib.stack;

public class StackIsFullException extends RuntimeException {
    public StackIsFullException() {
        super();
    }

    public StackIsFullException(String message) {
        super(message);
    }
}
