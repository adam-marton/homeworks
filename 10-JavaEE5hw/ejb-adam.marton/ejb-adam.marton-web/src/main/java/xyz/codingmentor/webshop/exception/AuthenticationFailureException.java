package xyz.codingmentor.webshop.exception;

/**
 *
 * @author Ádám
 */
public class AuthenticationFailureException extends Exception {

    public AuthenticationFailureException() {
        //default constuctor
    }

    public AuthenticationFailureException(String message) {
        super(message);
    }
}
