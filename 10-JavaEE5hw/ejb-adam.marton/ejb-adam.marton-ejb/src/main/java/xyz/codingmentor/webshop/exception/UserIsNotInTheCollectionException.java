package xyz.codingmentor.webshop.exception;

/**
 *
 * @author Ádám
 */
public class UserIsNotInTheCollectionException extends RuntimeException {

    public UserIsNotInTheCollectionException() {
        //default constructor
    }

    public UserIsNotInTheCollectionException(String message) {
        super(message);
    }
}
