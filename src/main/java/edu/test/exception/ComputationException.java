package edu.test.exception;

/**
 * Created by kash on 5/22/16.
 */
public class ComputationException extends Exception {
    public ComputationException(String message) {
        super(message);
    }
    public ComputationException(String message, Throwable cause) {
        super(message, cause);
    }
}
