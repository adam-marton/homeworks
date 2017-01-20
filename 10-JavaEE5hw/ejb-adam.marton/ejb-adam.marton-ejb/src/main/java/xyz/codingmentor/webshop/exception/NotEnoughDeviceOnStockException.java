package xyz.codingmentor.webshop.exception;

/**
 *
 * @author Ádám
 */
public class NotEnoughDeviceOnStockException extends RuntimeException {

    public NotEnoughDeviceOnStockException() {
        //default constructor
    }

    public NotEnoughDeviceOnStockException(String message) {
        super(message);
    }
}
