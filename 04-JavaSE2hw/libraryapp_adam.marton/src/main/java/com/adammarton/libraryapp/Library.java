package com.adammarton.libraryapp;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ádám
 */
public class Library {
    private final List<LibraryItem> items;
    private final LibraryLog libraryLog;
    
    public Library() {
        items = new ArrayList<>();
        libraryLog = LibraryLog.getInstance();
    }
    
    public void addItem(LibraryItem item) {
        items.add(item);
    }
    
    public void borrow(LibraryItem item, String borrowerName, String date) {
        libraryLog.addBorrow(item, borrowerName, date);
    }
    
    public void bringBack(LibraryItem item, String date) {
        libraryLog.addBringBack(item, date);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Content of the library:");
        for(LibraryItem i : items) {
            stringBuilder.append(i.toString());
        }
        return stringBuilder.toString();
    }
    
    public LibraryItem getItem(int element) {
        return items.get(element-1);
    }
}
