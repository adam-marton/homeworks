package com.adammarton.libraryapp;

/**
 *
 * @author Ádám
 */
public class BorrowDetail {
    private final String borrowerName;
    private final String borrowDate;
    private String bringBackDate;
    private boolean isBorrowed;
    
    public BorrowDetail(String borrowerName, String borrowDate) {
        this.borrowerName = borrowerName;
        this.borrowDate = borrowDate;
        this.isBorrowed = true;
    }
    
    public String getBorrowerName() {
        return borrowerName;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getBringBackDate() {
        return bringBackDate;
    }

    public void setBringBackDate(String bringBackDate) {
        this.bringBackDate = bringBackDate;
        this.isBorrowed = false;
    }
    
    public boolean isBorrowed() {
        return isBorrowed;
    }
}
