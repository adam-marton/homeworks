package xyz.codingmentor.exception;

/**
 *
 * @author Ádám
 */
public class DeviceIsAlreadyInTheCollectionException extends RuntimeException{

    public DeviceIsAlreadyInTheCollectionException() {
        //default constructor
    }

    public DeviceIsAlreadyInTheCollectionException(String message) {
        super(message);
    }

    public DeviceIsAlreadyInTheCollectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviceIsAlreadyInTheCollectionException(Throwable cause) {
        super(cause);
    }

    public DeviceIsAlreadyInTheCollectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
