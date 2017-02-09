package xyz.codingmentor.movie.repository;

import javax.persistence.EntityManager;

/**
 *
 * @author Ádám
 * @param <T>
 */
public abstract class AbstractCRUDRepository<T> {
    
    public AbstractCRUDRepository() {
        //default constructor
    }
    
    public void persist(T entity) {
        getEntityManager().persist(entity);
    }

    public T find(Long entityId) {
        return getEntityManager().find(getEntityClass(), entityId);
    }

    public T merge(T entity) {
        return getEntityManager().merge(entity);
    }

    public void remove(Long entityId) {
        getEntityManager().remove(find(entityId));
    }
    
    protected abstract Class<T> getEntityClass();
    
    protected abstract EntityManager getEntityManager();
}