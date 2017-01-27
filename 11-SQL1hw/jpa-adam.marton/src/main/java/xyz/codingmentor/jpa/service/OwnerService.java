package xyz.codingmentor.jpa.service;

import java.util.List;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import xyz.codingmentor.jpa.api.OwnerRepository;
import xyz.codingmentor.jpa.api.RepositoryException;
import xyz.codingmentor.jpa.entity.Owner;

/**
 *
 * @author Ádám
 */
public class OwnerService {
    @Inject
    private OwnerRepository ownerRepository;
    
    public OwnerService() {
        //default constructor
    }
            
    public Owner createOwner(String id) throws RepositoryException {
        return ownerRepository.createOwner(id);
    }
    
    public Owner findOwner(String id) throws RepositoryException {
        return ownerRepository.findOwner(id);
    }
    
    public List<String> getOwnersNameOrderedAboveAge(Integer age) throws RepositoryException {
        return ownerRepository.getOwnersNameOrderedAboveAge(age);
    }
    
    public List<Owner> getOwnersByName(String name) throws RepositoryException {
        return ownerRepository.getOwnersByName(name);
    }
    
    public void updateOwner(Owner owner) throws RepositoryException {
        ownerRepository.updateOwner(owner);
    }
    
    public void updatePhoneWhereIsNull(String number) throws RepositoryException {
        ownerRepository.updatePhoneWhereIsNull(number);
    }
    
    public void removeOwner(String id) throws RepositoryException {
        ownerRepository.removeOwner(id);
    }
    
    public void removeOwnersByName(String name) throws RepositoryException {
        ownerRepository.removeOwnersByName(name);
    }
    
    public void removeOwnersUnder18() throws RepositoryException {
        ownerRepository.removeOwnersUnder18();
    }
    
    @PreDestroy
    private void preDestroy() {
        ownerRepository.close();
    }
}
