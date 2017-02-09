package xyz.codingmentor.movie.api;

/**
 *
 * @author Ádám
 * @param <T>
 */
public interface CRUDRepository<T> {
    
    void persist(T entity);
    
    T find(Long entityId);
    
    T merge(T entity);
    
    void remove(Long entityId);
}
