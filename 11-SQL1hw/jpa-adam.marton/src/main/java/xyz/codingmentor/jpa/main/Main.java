package xyz.codingmentor.jpa.main;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import xyz.codingmentor.jpa.api.RepositoryException;

/**
 *
 * @author Ádám
 */
public class Main {
    
    private Main() {
        //default constructor
    }
    
    public static void main(String[] args) throws RepositoryException {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        
        Application application = container.instance().select(Application.class).get();
        application.execute();
        
        weld.shutdown();
    }
}
