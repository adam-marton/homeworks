package com.adammarton.libraryapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ádám
 */
public class LibraryLogTest {
    LibraryLog libraryLog;
    
    @Before
    public void setUp() {
        libraryLog = LibraryLog.getInstance();
    }
    
    @Test
    public void testGetInstance() {
        LibraryLog testLog = LibraryLog.getInstance();
        assertEquals(libraryLog, testLog);
    }
    
    @Test
    public void testAddBorrow() {
        LibraryItem testItem = new LibraryItem(ItemType.BOOK, "Test Add", "Unit Test", "2016.12.15.", "1", 222);
        libraryLog.addBorrow(testItem, "Unit Tester", "2016.12.15.");
        assertEquals("Unit Tester", libraryLog.getLog().get(testItem).getBorrowerName());
    }
    
    @Test(expected = LibraryItemAlreadyBorrowedException.class)
    public void testAddBorrowException() {
        LibraryItem testItem = new LibraryItem(ItemType.BOOK, "Test Borrow", "Unit Test", "2016.12.15.", "1", 222);
        libraryLog.addBorrow(testItem, "Unit Tester", "2016.12.15.");
        libraryLog.addBorrow(testItem, "Exception Expected", "2016.12.16.");
    }
    
    @Test
    public void testAddBringBack() {
        LibraryItem testItem = new LibraryItem(ItemType.BOOK, "Test BringBack", "Unit Test", "2016.12.15.", "1", 222);
        libraryLog.addBorrow(testItem, "Unit Tester", "2016.12.15.");
        libraryLog.addBringBack(testItem, "2016.12.16.");
        assertEquals("2016.12.16.", libraryLog.getLog().get(testItem).getBringBackDate());
    }
}
