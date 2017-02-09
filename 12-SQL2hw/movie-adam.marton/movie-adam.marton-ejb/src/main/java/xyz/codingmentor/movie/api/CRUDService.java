package xyz.codingmentor.movie.api;

/**
 *
 * @author Ádám
 * @param <T>
 */
public interface CRUDService<T> {

    void createEntity(T entity);

    T getEntityById(Long entityId);

    T updateEntity(T entity);

    void removeEntity(Long entityId);
}
