package com.adammarton.libraryapp;

/**
 *
 * @author Ádám
 */
public class LibraryItem {
    private final ItemType type;
    private final String title;
    private final String author;
    private final String date;
    private final String serialNumber;
    private final int pageNumber;
    
    public LibraryItem(ItemType type, String title, String author, String date, 
            String serialNumber, int pageNumber) {
        this.type = type;
        this.title = title;
        this.author = author;
        this.date = date;
        this.serialNumber = serialNumber;
        this.pageNumber = pageNumber;
    }

    public ItemType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public String toString() {
        return "\nType: " + type + "\nTitle: " + title + "\nAuthor: " + author + "\nPublication date: " 
                + date + "\nSerial number: " + serialNumber + "\nPages: " + pageNumber;
    }
    
    
}
