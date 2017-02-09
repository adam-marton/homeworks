package xyz.codingmentor.movie.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.movie.api.CRUDRepository;
import xyz.codingmentor.movie.api.CRUDRepositoryQualifier;
import xyz.codingmentor.movie.api.Entity;
import xyz.codingmentor.movie.entity.Thespian;

/**
 *
 * @author Ádám
 */
@Stateless
@CRUDRepositoryQualifier(Entity.THESPIAN)
public class ThespianRepository extends AbstractCRUDRepository<Thespian> implements CRUDRepository<Thespian> {
    
    @PersistenceContext(unitName = "moviePU")
    private EntityManager entityManager;

    @Override
    protected Class<Thespian> getEntityClass() {
        return Thespian.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
