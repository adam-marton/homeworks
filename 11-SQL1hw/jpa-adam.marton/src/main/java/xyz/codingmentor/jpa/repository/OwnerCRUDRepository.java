package xyz.codingmentor.jpa.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import xyz.codingmentor.jpa.api.RepositoryException;
import xyz.codingmentor.jpa.entity.Owner;
import xyz.codingmentor.jpa.api.OwnerCRUDRepositoryInterface;

/**
 *
 * @author Ádám
 */
@Stateless
public class OwnerCRUDRepository implements OwnerCRUDRepositoryInterface {
    private final EntityManagerFactory factory;
    private final EntityManager entityManager;
    
    public OwnerCRUDRepository() {
        factory = Persistence.createEntityManagerFactory("carParkPU");
        entityManager = factory.createEntityManager();
    }
    
    @Override
    public Owner createOwner(String id) throws RepositoryException {
        Owner owner = new Owner();
        owner.setId(id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(owner);
        tx.commit();
        return owner;
    }

    @Override
    public Owner findOwner(String id) throws RepositoryException {
        Owner owner = entityManager.find(Owner.class, id);
        if(null != owner) {
            return owner;
        }
        return null;
    }
    
    @Override
    public void updateOwner(Owner owner) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(owner);
        tx.commit();
    }

    @Override
    public void removeOwner(String id) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Owner owner = entityManager.find(Owner.class, id);
        if(null != owner) {
            entityManager.remove(owner);
        }
        tx.commit();
    }
    
    @Override
    public void close() {
        factory.close();
        entityManager.close();
    }
}
