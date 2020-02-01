package com.datalib.list;


public class ListIndexOutOfBondsException extends RuntimeException {
    public ListIndexOutOfBondsException() {
        super();
    }

    public ListIndexOutOfBondsException(String message) {
        super(message);
    }
}
