package com.adammarton.libraryapp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ádám
 */
public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    
    private Main() {
        //Private constructor because of sonar
    }
    
    public static void main(String[] args) {
        Library library = new Library();
        LibraryItem book1 = new LibraryItem(ItemType.BOOK, "Harry Potter and the Philosopher’s Stone", 
                "Joanne Kathleen Rowling", "1997.06.26.", "963-8386-77-0", 286);
        LibraryItem book2 = new LibraryItem(ItemType.BOOK, "Deathwing", "Richard A. Knaak", 
                "2001.02.01.", "963-9441-52-X", 328);
        LibraryItem journal1 = new LibraryItem(ItemType.JOURNAL, "GameStar", "GameStar", 
                "2010/08", "9 771787 902009", 112);
        LibraryItem journal2 = new LibraryItem(ItemType.JOURNAL, "PC Guru", "PC Guru", 
                "2016/03", "9 771217 638003", 85);
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(journal1);
        library.addItem(journal2);
        LOGGER.log(Level.INFO, library.toString());
        library.borrow(library.getItem(2), "Adam Marton", "2016.12.06.");
        library.borrow(journal2, "John Doe", "2016.12.11.");
        library.bringBack(book2, "2016.12.14.");
    }
}
