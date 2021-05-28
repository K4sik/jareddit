package com.kas.jareddit.exception;

public class JARedditException extends RuntimeException {

    public JARedditException(String message, Exception exception) {
        super(message, exception);
    }

    public JARedditException(String message) {
        super(message);
    }

}
