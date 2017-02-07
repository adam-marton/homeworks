package xyz.codingmentor.jms.api;

import xyz.codingmentor.jms.entity.Flight;

/**
 *
 * @author Ádám
 */
public interface FlightNoticeServiceInterface {
    
    void noticeAboutDeletedFlight(Flight flight);
    
    void noticeAboutUpdatedFlight(Flight oldFlight, Flight updatedFlight);
    
    void sendMessageToTopic(String flightString);
}
