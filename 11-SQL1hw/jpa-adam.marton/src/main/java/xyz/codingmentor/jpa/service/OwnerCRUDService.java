package xyz.codingmentor.jpa.service;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import xyz.codingmentor.jpa.api.RepositoryException;
import xyz.codingmentor.jpa.entity.Owner;
import xyz.codingmentor.jpa.api.OwnerCRUDRepositoryInterface;

/**
 *
 * @author Ádám
 */
public class OwnerCRUDService {
    @Inject
    private OwnerCRUDRepositoryInterface crudRepository;
    
    public OwnerCRUDService() {
        //default constructor
    }
            
    public Owner createOwner(String id) throws RepositoryException {
        return crudRepository.createOwner(id);
    }
    
    public Owner findOwner(String id) throws RepositoryException {
        return crudRepository.findOwner(id);
    }

    public void updateOwner(Owner owner) throws RepositoryException {
        crudRepository.updateOwner(owner);
    }
    
    public void removeOwner(String id) throws RepositoryException {
        crudRepository.removeOwner(id);
    }
    @PreDestroy
    private void preDestroy() {
        crudRepository.close();
    }
}
