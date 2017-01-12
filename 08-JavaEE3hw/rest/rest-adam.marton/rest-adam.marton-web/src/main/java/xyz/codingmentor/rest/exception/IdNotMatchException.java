package xyz.codingmentor.rest.exception;

/**
 *
 * @author Ádám
 */
public class IdNotMatchException extends RuntimeException {

    public IdNotMatchException() {
        super();
    }

    public IdNotMatchException(String msg) {
        super(msg);
    }
}