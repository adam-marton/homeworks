package xyz.codingmentor.jms.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.jms.api.FlightRepositoryInterface;
import xyz.codingmentor.jms.entity.Flight;
import xyz.codingmentor.jms.api.FlightCRUDServiceInterface;

/**
 *
 * @author Ádám
 */
@Stateless
public class FlightCRUDService implements FlightCRUDServiceInterface {
    
    private FlightRepositoryInterface flightRepository;
    
    public FlightCRUDService() {
        //default constructor
    }
    
    @Inject
    public FlightCRUDService(FlightRepositoryInterface flightRepository) {
        this.flightRepository = flightRepository;
    }
    
    @Override
    public void createFlight(Flight flight) {
        flightRepository.persist(flight);
    }

    @Override
    public Flight getFlightById(Long flightId) {
        return flightRepository.find(flightId);
    }
    
    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight updateFlight(Flight flight) {
        return flightRepository.merge(flight);
    }

    @Override
    public void deleteFlight(Long flightId) {
        flightRepository.remove(flightId);
    }
}
