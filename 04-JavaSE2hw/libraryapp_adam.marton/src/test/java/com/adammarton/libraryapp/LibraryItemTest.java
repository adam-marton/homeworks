package com.adammarton.libraryapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ádám
 */
public class LibraryItemTest {
    LibraryItem libraryItem;
    
    @Before
    public void setUp() {
        libraryItem = new LibraryItem(ItemType.BOOK, "Test LibraryItem", "Unit Test", "2016.12.15.", "1", 222);
    }
    
    @Test
    public void testGetType() {
        assertEquals(ItemType.BOOK, libraryItem.getType());
    }

    @Test
    public void testGetTitle() {
        assertEquals("Test LibraryItem", libraryItem.getTitle());
    }
    
    @Test
    public void testGetAuthor() {
        assertEquals("Unit Test", libraryItem.getAuthor());
    }
    
    @Test
    public void testGetDate() {
        assertEquals("2016.12.15.", libraryItem.getDate());
    }
    
    @Test
    public void testGetSerialNumber() {
        assertEquals("1", libraryItem.getSerialNumber());
    }
    
    @Test
    public void testGetPageNumber() {
        assertEquals(222, libraryItem.getPageNumber());
    }
    
    @Test
    public void testToString() {
        assertEquals("\nType: " + libraryItem.getType() + "\nTitle: " + libraryItem.getTitle() + 
                "\nAuthor: " + libraryItem.getAuthor() + "\nPublication date: " + libraryItem.getDate() + 
                "\nSerial number: " + libraryItem.getSerialNumber() + "\nPages: " + 
                libraryItem.getPageNumber(), libraryItem.toString());
    }
}
