package com.adammarton.libraryapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ádám
 */
public class LibraryTest {
    Library library;
    
    @Before
    public void setUp() {
        library = new Library();
    }
    
    @Test
    public void testAddItem() {
        LibraryItem testItem = new LibraryItem(ItemType.BOOK, "Test Add", "Unit Test", "2016.12.15.", "1", 222);
        library.addItem(testItem);
        assertEquals(testItem, library.getItem(1));
    }
    
    @Test
    public void testBorrow() {
        LibraryItem testItem = new LibraryItem(ItemType.BOOK, "Test Borrow", "Unit Test", "2016.12.15.", "1", 222);
        library.addItem(testItem);
        library.borrow(testItem, "Unit Tester", "2016.12.02.");
        LibraryLog log = LibraryLog.getInstance();
        assertEquals("Unit Tester", log.getLog().get(testItem).getBorrowerName());
        assertEquals("2016.12.02.", log.getLog().get(testItem).getBorrowDate());
    }
    
    @Test(expected = LibraryItemAlreadyBorrowedException.class)
    public void testBorrowException() {
        LibraryItem testItem = new LibraryItem(ItemType.BOOK, "Test Borrow", "Unit Test", "2016.12.15.", "1", 222);
        library.addItem(testItem);
        library.borrow(testItem, "Unit Tester", "2016.12.02.");
        library.borrow(testItem, "Exception Expected", "2016.12.15.");
    }
    
    @Test
    public void testBringBack() {
        LibraryItem testItem = new LibraryItem(ItemType.BOOK, "Test BringBack", "Unit Test", "2016.12.15.", "1", 222);
        library.addItem(testItem);
        library.borrow(testItem, "Unit Tester", "2016.12.02.");
        library.bringBack(library.getItem(1), "2016.12.15.");
        LibraryLog log = LibraryLog.getInstance();
        assertEquals("2016.12.15.", log.getLog().get(testItem).getBringBackDate());
    }
    
    @Test
    public void testGetItem() {
        LibraryItem testItem = new LibraryItem(ItemType.BOOK, "Test GetItem", "Unit Test", "2016.12.15.", "1", 222);
        library.addItem(testItem);
        LibraryItem returnItem = library.getItem(1);
        assertEquals(testItem, returnItem);
    }
}
