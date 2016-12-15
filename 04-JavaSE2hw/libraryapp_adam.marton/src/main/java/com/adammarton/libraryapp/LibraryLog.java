package com.adammarton.libraryapp;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ádám
 */
public class LibraryLog {
    private static LibraryLog instance;
    private final Map<LibraryItem, BorrowDetail> logs;
    
    private LibraryLog() {
        logs = new HashMap<>();
    }
    
    public static LibraryLog getInstance() {
        if(null == instance) {
            instance = new LibraryLog();
        }
        return instance;
    }
    
    public void addBorrow(LibraryItem item, String borrowerName, String date) {
        if(logs.containsKey(item)) {
            BorrowDetail detail = logs.get(item);
            if(detail.isBorrowed()) {
                throw new LibraryItemAlreadyBorrowedException();
            }
        }
        else {
            logs.put(item, new BorrowDetail(borrowerName, date));
        }
    }
    
    public void addBringBack(LibraryItem item, String date) {
        if(logs.containsKey(item)) {
            BorrowDetail detail = logs.get(item);
            if(detail.isBorrowed()) {
                detail.setBringBackDate(date);
                logs.put(item, detail);
            }
        }
    }
    
    public Map<LibraryItem, BorrowDetail> getLog() {
        return logs;
    }
}
