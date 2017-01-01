package xyz.codingmentor.exception;

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

    public UserIsNotInTheCollectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIsNotInTheCollectionException(Throwable cause) {
        super(cause);
    }

    public UserIsNotInTheCollectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
