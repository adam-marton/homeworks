package xyz.codingmentor.jpa.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import xyz.codingmentor.jpa.api.OwnerRepository;
import xyz.codingmentor.jpa.api.RepositoryException;
import xyz.codingmentor.jpa.entity.Owner;

/**
 *
 * @author Ádám
 */
@Stateless
public class JPAOwnerRepository implements OwnerRepository {
    private final EntityManagerFactory factory;
    private final EntityManager entityManager;
    
    public JPAOwnerRepository() {
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
    public List<String> getOwnersNameOrderedAboveAge(Integer age) throws RepositoryException {
        String selectQuery = "SELECT o.name FROM Owner o WHERE o.dateOfBirth < :date ORDER BY o.name ASC";
        TypedQuery<String> query = entityManager.createQuery(selectQuery, String.class);
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.YEAR, age);
        query.setParameter("date", calendar.getTime());
        return query.getResultList();
    }

    @Override
    public List<Owner> getOwnersByName(String name) throws RepositoryException {
        String selectQuery = "SELECT o FROM Owner o WHERE o.name LIKE :name";
        TypedQuery<Owner> query = entityManager.createQuery(selectQuery, Owner.class);
        query.setParameter("name", "%" + name + "%");
        List<Owner> owners = query.getResultList();
        for(Owner o : owners) {
            entityManager.refresh(o);
        }
        return owners;
    }

    @Override
    public void updateOwner(Owner owner) throws RepositoryException {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.merge(owner);
        tx.commit();
    }
    
    @Override
    public void updatePhoneWhereIsNull(String number) throws RepositoryException {
        String updateQuery = "UPDATE Owner o SET o.phone = :number WHERE o.phone IS NULL";
        Query query = entityManager.createQuery(updateQuery);
        query.setParameter("number", number);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        query.executeUpdate();
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
    public void removeOwnersByName(String name) throws RepositoryException {
        String deleteQuery = "DELETE FROM Owner o WHERE o.name LIKE :name";
        Query query = entityManager.createQuery(deleteQuery);
        query.setParameter("name", "%" + name + "%");
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        query.executeUpdate();
        tx.commit();
    }
    
    @Override
    public void removeOwnersUnder18() throws RepositoryException {
        String deleteQuery = "DELETE FROM Owner o WHERE o.dateOfBirth > :date";
        Query query = entityManager.createQuery(deleteQuery);
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.YEAR, -18);
        query.setParameter("date", calendar.getTime());
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        query.executeUpdate();
        tx.commit();
    }
    
    @Override
    public void close() {
        factory.close();
        entityManager.close();
    }
}
