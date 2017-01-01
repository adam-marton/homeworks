package xyz.codingmentor.exception;

/**
 *
 * @author Ádám
 */
public class DeviceIsNotInTheCollectionException extends RuntimeException {

    public DeviceIsNotInTheCollectionException() {
        //default constructor
    }

    public DeviceIsNotInTheCollectionException(String message) {
        super(message);
    }

    public DeviceIsNotInTheCollectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeviceIsNotInTheCollectionException(Throwable cause) {
        super(cause);
    }

    public DeviceIsNotInTheCollectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
