package xyz.codingmentor.movie.service;

import xyz.codingmentor.movie.api.CRUDRepository;

/**
 *
 * @author Ádám
 * @param <T>
 */
public class GenericCRUDService<T> {
    
    private final CRUDRepository<T> crudRepository;
    
    public GenericCRUDService(CRUDRepository<T> repository) {
        this.crudRepository = repository;
    }

    public void createEntity(T entity) {
        crudRepository.persist(entity);
    }

    public T getEntityById(Long entityId) {
        return crudRepository.find(entityId);
    }

    public T updateEntity(T entity) {
        return crudRepository.merge(entity);
    }

    public void removeEntity(Long entityId) {
        crudRepository.remove(entityId);
    }
}