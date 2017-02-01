package xyz.codingmentor.jpa.main;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import xyz.codingmentor.jpa.api.RepositoryException;
import xyz.codingmentor.jpa.entity.CarPark;
import xyz.codingmentor.jpa.entity.Owner;
import xyz.codingmentor.jpa.service.OwnerCRUDService;
import xyz.codingmentor.jpa.service.OwnerQueryService;

/**
 *
 * @author Ádám
 */
public class Application {
    private static final Logger LOGGER = Logger.getLogger(Application.class.getName());
    @Inject
    private OwnerCRUDService crudService;
    @Inject OwnerQueryService queryService;
    
    public Application() {
        //default constructor
    }
    
    public void execute() throws RepositoryException {
        buildOwner("123456AB", "John Doe", new Date(), "+36301234567", null);
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.YEAR, -30);
        buildOwner("987654XY", "Jane Doe", calendar.getTime(), "+36201234567", null);
        calendar = new GregorianCalendar();
        calendar.add(Calendar.YEAR, -20);
        buildOwner("112233ZZ", "Jack Doe", calendar.getTime(), null, null);
        printOwners(queryService.getOwnersByName("Doe"));
        List<String> ownersNameOrdered = queryService.getOwnersNameOrderedAboveAge(18);
        LOGGER.log(Level.INFO, "Owners ordered by name:");
        for(String s : ownersNameOrdered) {
            LOGGER.log(Level.INFO, s);
        }
        queryService.updatePhoneWhereIsNull("+361020304");
        LOGGER.log(Level.INFO, "NULL phone number is updated!");
        printOwners(queryService.getOwnersByName("Doe"));
        queryService.removeOwnersUnder18();
        LOGGER.log(Level.INFO, "Owners under age 18 has been deleted!");
        printOwners(queryService.getOwnersByName("Doe"));
        queryService.removeOwnersByName("Doe");
        LOGGER.log(Level.INFO, "Owners by name 'Doe' has been deleted!");
        if(queryService.getOwnersByName("Doe").isEmpty()) {
            LOGGER.log(Level.INFO, "There is no owner named 'Doe' is in the database.");
        }
    }
    
    private void buildOwner(String id, String name, Date date, String phone, CarPark carPark) throws RepositoryException {
        Owner owner = crudService.createOwner(id);
        owner.setName(name);
        owner.setDateOfBirth(date);
        owner.setPhone(phone);
        owner.setCarPark(carPark);
        crudService.updateOwner(owner);
    }
    
    private static void printOwners(List<Owner> owners) throws RepositoryException {
        for(Owner o : owners) {
            LOGGER.log(Level.INFO, o.toString());
        }
    }
}
