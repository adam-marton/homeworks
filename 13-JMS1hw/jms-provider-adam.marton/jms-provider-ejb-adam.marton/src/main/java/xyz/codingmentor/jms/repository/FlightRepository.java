package xyz.codingmentor.jms.repository;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.codingmentor.jms.api.FlightRepositoryInterface;
import xyz.codingmentor.jms.entity.Flight;

/**
 *
 * @author Ádám
 */
@Stateless
public class FlightRepository implements FlightRepositoryInterface {
    
    @PersistenceContext(unitName = "flightPU")
    private EntityManager em;
    
    public FlightRepository() {
        //default constructor
    }
    
    @Override
    public void persist(Flight flight) {
        em.persist(flight);
    }

    @Override
    public Flight find(Long flightId) {
        return em.find(Flight.class, flightId);
    }
    
    @Override
    public List<Flight> findAll() {
        return em.createQuery("SELECT f FROM Flight f", Flight.class).getResultList();
    }

    @Override
    public Flight merge(Flight flight) {
        return em.merge(flight);
    }

    @Override
    public void remove(Long flightId) {
        em.remove(find(flightId));
    }
}
