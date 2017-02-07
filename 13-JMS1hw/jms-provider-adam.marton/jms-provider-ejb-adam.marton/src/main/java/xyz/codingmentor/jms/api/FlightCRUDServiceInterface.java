package xyz.codingmentor.jms.api;

import java.util.List;
import xyz.codingmentor.jms.entity.Flight;

/**
 *
 * @author Ádám
 */
public interface FlightCRUDServiceInterface {
    
    void createFlight(Flight flight);

    Flight getFlightById(Long flightId);
    
    List<Flight> getAllFlights();

    Flight updateFlight(Flight flight);

    void deleteFlight(Long flightId);
}
