package xyz.codingmentor.movie.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.movie.api.CRUDRepository;
import xyz.codingmentor.movie.api.CRUDRepositoryQualifier;
import xyz.codingmentor.movie.api.Entity;
import xyz.codingmentor.movie.entity.Trailer;

/**
 *
 * @author Ádám
 */
@Stateless
@CRUDRepositoryQualifier(Entity.TRAILER)
public class TrailerRepository extends AbstractCRUDRepository<Trailer> implements CRUDRepository<Trailer> {
    
    @PersistenceContext(unitName = "moviePU")
    private EntityManager entityManager;    

    @Override
    protected Class<Trailer> getEntityClass() {
        return Trailer.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
