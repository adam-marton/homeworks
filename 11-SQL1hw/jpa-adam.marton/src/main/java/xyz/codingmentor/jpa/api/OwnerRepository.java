package xyz.codingmentor.jpa.api;

import java.util.List;
import xyz.codingmentor.jpa.entity.Owner;

/**
 *
 * @author Ádám
 */
public interface OwnerRepository {
        
    Owner createOwner(String id) throws RepositoryException;
    
    Owner findOwner(String id) throws RepositoryException;
    
    List<String> getOwnersNameOrderedAboveAge(Integer age) throws RepositoryException;
    
    List<Owner> getOwnersByName(String name) throws RepositoryException;
    
    void updateOwner(Owner owner) throws RepositoryException;
    
    void updatePhoneWhereIsNull(String number) throws RepositoryException;
    
    void removeOwner(String id) throws RepositoryException;
    
    void removeOwnersByName(String name) throws RepositoryException;
    
    void removeOwnersUnder18() throws RepositoryException;
    
    void close();
}
