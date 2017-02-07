package xyz.codingmentor.jms.api;

import java.util.List;
import xyz.codingmentor.jms.entity.Flight;

/**
 *
 * @author Ádám
 */
public interface FlightRepositoryInterface {
    
    void persist(Flight flight);
    
    Flight find(Long flightId);
    
    List<Flight> findAll();
            
    Flight merge(Flight flight);
    
    void remove(Long flightId);
}
