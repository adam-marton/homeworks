package xyz.codingmentor.jpa.service;

import java.util.List;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import xyz.codingmentor.jpa.api.OwnerQueryRepositoryInterface;
import xyz.codingmentor.jpa.api.RepositoryException;
import xyz.codingmentor.jpa.entity.Owner;

/**
 *
 * @author Ádám
 */
public class OwnerQueryService {
    @Inject
    private OwnerQueryRepositoryInterface queryRepository;

    public OwnerQueryService() {
        //default constructor
    }

    public List<String> getOwnersNameOrderedAboveAge(Integer age) throws RepositoryException {
        return queryRepository.getOwnersNameOrderedAboveAge(age);
    }

    public List<Owner> getOwnersByName(String name) throws RepositoryException {
        return queryRepository.getOwnersByName(name);
    }

    public void updatePhoneWhereIsNull(String number) throws RepositoryException {
        queryRepository.updatePhoneWhereIsNull(number);
    }

    public void removeOwnersByName(String name) throws RepositoryException {
        queryRepository.removeOwnersByName(name);
    }

    public void removeOwnersUnder18() throws RepositoryException {
        queryRepository.removeOwnersUnder18();
    }

    @PreDestroy
    private void preDestroy() {
        queryRepository.close();
    }
}
