package xyz.codingmentor.jpa.api;

import xyz.codingmentor.jpa.entity.Owner;

/**
 *
 * @author Ádám
 */
public interface OwnerCRUDRepositoryInterface {
        
    Owner createOwner(String id) throws RepositoryException;
    
    Owner findOwner(String id) throws RepositoryException;
    
    void updateOwner(Owner owner) throws RepositoryException;
    
    void removeOwner(String id) throws RepositoryException;
    
    void close();
}
