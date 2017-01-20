package xyz.codingmentor.webshop.exception;

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
}
