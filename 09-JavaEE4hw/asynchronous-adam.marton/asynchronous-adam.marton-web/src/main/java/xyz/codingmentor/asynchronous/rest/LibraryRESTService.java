package xyz.codingmentor.asynchronous.rest;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.asynchronous.entity.BookEntity;
import xyz.codingmentor.asynchronous.service.LibrarySingleton;

/**
 *
 * @author Ádám
 */
@Path("/library")
public class LibraryRESTService {
    private static final Logger LOGGER = Logger.getLogger(LibraryRESTService.class.getName());
    
    @Inject
    private LibrarySingleton librarySingleton;
    
    /**
     *
     * http://localhost:8080/asynchronous-adam.marton-web/webresources/library/
     * Lekéri az összes könyvet a könyvtárból, ezeknek az id-ját használhatjuk a nyomtatáshoz és letöltéshez.
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<BookEntity> getBooks() {
        return librarySingleton.getBooks();
    }
    
    /**
     *
     * http://localhost:8080/asynchronous-adam.marton-web/webresources/library/print/{id}
     * Egy nyomtatást reprezentál, meghívja a LibrarySingleton printBook() metódusát, 
     * ami oldalanként 10 ms-ot vár, így modellezve a nyomtatás időtartamát.
     */
    @POST
    @Path("/print/{id}")
    public void printBook(@PathParam("id") String id) throws InterruptedException {
        LOGGER.log(Level.INFO, "User wants to print a book.");
        if(null != librarySingleton.getBookById(id)) {
            librarySingleton.printBook(id);
        }
        else {
            LOGGER.log(Level.INFO, "Book (id: {0}) doesn't exist.", librarySingleton.getBookById(id));
        }
        LOGGER.log(Level.INFO, "Waiting for the next command.");
    }
    
    /**
     *
     * http://localhost:8080/asynchronous-adam.marton-web/webresources/library/download/{id}
     * Egy letöltést mutat be, meghívja ennek az osztálynak a checkDownload metódusát, ami aztán aszinkron módon
     * hívja a LibrarySingleton downloadBook metódusát. Mint az előző esetben, itt is oldalanként 10 ms-ot vár,
     * ezzel modellezve a letöltés idejét.
     */
    @POST
    @Path("/download/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookEntity downloadBook(@PathParam ("id") String id) {
        LOGGER.log(Level.INFO, "User wants to download a book.");
        if(null != librarySingleton.getBookById(id)) {
            checkDownload(id);
            LOGGER.log(Level.INFO, "Waiting for the next command.");
            return librarySingleton.getBookById(id);
        }
        else {
            LOGGER.log(Level.INFO, "Book (id: {0}) doesn't exist.", librarySingleton.getBookById(id));
            throw new IllegalArgumentException();
        }
    }
    
    @Asynchronous
    public void checkDownload(String id) {
        CompletableFuture.runAsync(() -> { 
            try {
                Future<BookEntity> status = librarySingleton.downloadBook(id);
                BookEntity statusValue = status.get();
                LOGGER.log(Level.INFO, statusValue.toString());
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(LibraryRESTService.class.getName()).log(Level.SEVERE, null, ex);
            }
    });        
    }
}
