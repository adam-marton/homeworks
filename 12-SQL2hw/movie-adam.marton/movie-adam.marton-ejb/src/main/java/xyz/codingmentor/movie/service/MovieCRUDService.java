package xyz.codingmentor.movie.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.movie.api.CRUDRepository;
import xyz.codingmentor.movie.api.CRUDRepositoryQualifier;
import xyz.codingmentor.movie.api.CRUDService;
import xyz.codingmentor.movie.api.CRUDServiceQualifier;
import xyz.codingmentor.movie.api.Entity;
import xyz.codingmentor.movie.entity.Movie;

/**
 *
 * @author Ádám
 */
@Stateless
@CRUDServiceQualifier(Entity.MOVIE)
public class MovieCRUDService extends GenericCRUDService<Movie> implements CRUDService<Movie> {
    
    public MovieCRUDService() {
        super(null);
    }
    
    @Inject
    public MovieCRUDService(@CRUDRepositoryQualifier(Entity.MOVIE) CRUDRepository<Movie> repository) {
        super(repository);
    }
}
