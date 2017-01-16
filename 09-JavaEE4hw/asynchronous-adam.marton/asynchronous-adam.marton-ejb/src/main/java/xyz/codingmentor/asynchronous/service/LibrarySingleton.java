package xyz.codingmentor.asynchronous.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import xyz.codingmentor.asynchronous.entity.BookEntity;

/**
 *
 * @author Ádám
 */
@Singleton
public class LibrarySingleton {
    private static final Logger LOGGER = Logger.getLogger(LibrarySingleton.class.getName());
    private Map<String, BookEntity> books;

    @PostConstruct
    private void init() {
        books = new HashMap<>();
        BookEntity book1 = new BookEntity(UUID.randomUUID().toString(), "Richard A. Knaak", "Deathwing", 220);
        BookEntity book2 = new BookEntity(UUID.randomUUID().toString(), "George R. R. Martin", "A Game of Thrones", 694);
        BookEntity book3 = new BookEntity(UUID.randomUUID().toString(), "Dan Brown", "Inferno", 609);
        BookEntity book4 = new BookEntity(UUID.randomUUID().toString(), "James Dashner", "The Maze Runner", 375);
        books.put(book1.getId(), book1);
        books.put(book2.getId(), book2);
        books.put(book3.getId(), book3);
        books.put(book4.getId(), book4);
    }

    public BookEntity getBookById(String id) {
        return books.get(id);
    }

    public List<BookEntity> getBooks() {
        return new ArrayList(books.values());
    }

    @Asynchronous
    public void printBook(String id) throws InterruptedException {
        LOGGER.log(Level.INFO, "Started to print: {0}({1})",
                new Object[]{books.get(id).getTitle(), books.get(id).getAuthor()});
        Thread.sleep(books.get(id).getNumberOfPages() * 10L);
        LOGGER.log(Level.INFO, "Print finished.");
    }

    @Asynchronous
    public Future<BookEntity> downloadBook(String id) throws InterruptedException {
        LOGGER.log(Level.INFO, "Started to download: {0}({1})",
                new Object[]{books.get(id).getTitle(), books.get(id).getAuthor()});
        Thread.sleep(books.get(id).getNumberOfPages() * 10L);
        LOGGER.log(Level.INFO, "Download finished.");
        return new AsyncResult<>(books.get(id));
    }
}
