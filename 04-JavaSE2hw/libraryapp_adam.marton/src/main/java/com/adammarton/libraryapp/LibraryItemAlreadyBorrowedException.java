package com.adammarton.libraryapp;

/**
 *
 * @author Ádám
 */
public class LibraryItemAlreadyBorrowedException extends RuntimeException {

    public LibraryItemAlreadyBorrowedException() {
        //generated default constructor
    }

    public LibraryItemAlreadyBorrowedException(String message) {
        super(message);
    }

    public LibraryItemAlreadyBorrowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryItemAlreadyBorrowedException(Throwable cause) {
        super(cause);
    }

    public LibraryItemAlreadyBorrowedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
