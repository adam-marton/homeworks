package xyz.codingmentor.webshop.exception;

/**
 *
 * @author Ádám
 */
public class UserIsAlreadyInTheCollectionException extends RuntimeException {

    public UserIsAlreadyInTheCollectionException() {
        //default constructor
    }

    public UserIsAlreadyInTheCollectionException(String message) {
        super(message);
    } 
}
