package com.rahat.assurance.exception;

public class InvalidStatusException extends RuntimeException {

    public InvalidStatusException() {}

    public InvalidStatusException(String message) {
        super(message);
    }

    public InvalidStatusException(String message, Throwable cause) {
        super(message, cause);
    }
}
