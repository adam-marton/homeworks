package xyz.codingmentor.exception;

/**
 *
 * @author Ádám
 */
public class ValidationException extends RuntimeException {

    public ValidationException() {
        //default constructor
    }

    public ValidationException(String message) {
        super(message);
    }
}
