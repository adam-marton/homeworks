package xyz.codingmentor.webshop.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Ádám
 */
@javax.ws.rs.ApplicationPath("webshop")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(xyz.codingmentor.webshop.exception.AuthenticationFailureExceptionMapper.class);
        resources.add(xyz.codingmentor.webshop.exception.GeneralExceptionMapper.class);
        resources.add(xyz.codingmentor.webshop.rest.CartRESTService.class);
        resources.add(xyz.codingmentor.webshop.rest.DeviceRESTService.class);
        resources.add(xyz.codingmentor.webshop.rest.UserRESTService.class);
    }
}
