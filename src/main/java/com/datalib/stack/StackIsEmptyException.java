package com.datalib.stack;

public class StackIsEmptyException extends RuntimeException {
    public StackIsEmptyException() {
        super();
    }

    public StackIsEmptyException(String message) {
        super(message);
    }
}
