package xyz.codingmentor.movie.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.movie.api.CRUDRepository;
import xyz.codingmentor.movie.api.CRUDRepositoryQualifier;
import xyz.codingmentor.movie.api.Entity;
import xyz.codingmentor.movie.entity.Category;

/**
 *
 * @author Ádám
 */
@Stateless
@CRUDRepositoryQualifier(Entity.CATEGORY)
public class CategoryRepository extends AbstractCRUDRepository<Category> implements CRUDRepository<Category> {
    
    @PersistenceContext(unitName = "moviePU")
    private EntityManager entityManager;
    
    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}
