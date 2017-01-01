package xyz.codingmentor.exception;

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

    public UserIsAlreadyInTheCollectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIsAlreadyInTheCollectionException(Throwable cause) {
        super(cause);
    }

    public UserIsAlreadyInTheCollectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
