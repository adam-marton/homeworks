package xyz.codingmentor.movie.repository;

import xyz.codingmentor.movie.api.CRUDRepository;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.movie.api.CRUDRepositoryQualifier;
import xyz.codingmentor.movie.api.Entity;
import xyz.codingmentor.movie.entity.Movie;

/**
 *
 * @author Ádám
 */
@Stateless
@CRUDRepositoryQualifier(Entity.MOVIE)
public class MovieRepository extends AbstractCRUDRepository<Movie> implements CRUDRepository<Movie> {
    
    @PersistenceContext(unitName = "moviePU")
    private EntityManager entityManager;

    @Override
    protected Class<Movie> getEntityClass() {
        return Movie.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
