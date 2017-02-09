package xyz.codingmentor.movie.config;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Ádám
 */
@javax.ws.rs.ApplicationPath("/rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(xyz.codingmentor.movie.rest.CategoryCRUDResource.class);
        resources.add(xyz.codingmentor.movie.rest.JoinResource.class);
        resources.add(xyz.codingmentor.movie.rest.MovieCRUDResource.class);
        resources.add(xyz.codingmentor.movie.rest.SearchResource.class);
        resources.add(xyz.codingmentor.movie.rest.ThespianCRUDResource.class);
        resources.add(xyz.codingmentor.movie.rest.TrailerCRUDResource.class);
    }
}
