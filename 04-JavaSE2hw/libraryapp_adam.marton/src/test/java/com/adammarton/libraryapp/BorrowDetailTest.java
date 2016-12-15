package com.adammarton.libraryapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ádám
 */
public class BorrowDetailTest {
    BorrowDetail detail;
    
    @Before
    public void setUp() {
        detail = new BorrowDetail("Adam Marton", "2016.12.14.");
    }
 
    @Test
    public void testGetBorrowerName() {
        assertEquals("Adam Marton", detail.getBorrowerName());
    }
    
    @Test
    public void testGetBorrowDate() {
        assertEquals("2016.12.14.", detail.getBorrowDate());
    }

    @Test
    public void testGetBringBackDate() {
        assertEquals(null, detail.getBringBackDate());
    }
    
    @Test
    public void testSetBringBackDate() {
        detail.setBringBackDate("2016.12.15.");
        assertEquals("2016.12.15.", detail.getBringBackDate());
    }

    @Test
    public void testIsBorrowed() {
        assertEquals(true, detail.isBorrowed());
        detail.setBringBackDate("2016.12.15.");
        assertEquals(false, detail.isBorrowed());
    }
}
