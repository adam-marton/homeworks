package xyz.codingmentor.jms.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Ádám
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(xyz.codingmentor.jms.rest.FlightResource.class);
    }
}
