package xyz.codingmentor.webshop.exception;

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
}
