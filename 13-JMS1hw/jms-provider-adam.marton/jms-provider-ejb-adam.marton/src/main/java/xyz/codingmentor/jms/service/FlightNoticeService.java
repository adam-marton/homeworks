package xyz.codingmentor.jms.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;
import xyz.codingmentor.jms.api.FlightNoticeServiceInterface;
import xyz.codingmentor.jms.entity.Flight;

/**
 *
 * @author Ádám
 */
@Stateless
public class FlightNoticeService implements FlightNoticeServiceInterface {
    
    private JMSContext context;
    @Resource(lookup = "jms/flightTopic")
    private Topic flightTopic;
    
    public FlightNoticeService() {
        //default constructor
    }
    
    @Inject
    public FlightNoticeService(JMSContext context) {
        this.context = context;
    }
    
    @Override
    public void noticeAboutDeletedFlight(Flight flight) {
        String flightString = "Flight has been deleted:" + flight.toString();
        sendMessageToTopic(flightString);
    }
    
    @Override
    public void noticeAboutUpdatedFlight(Flight oldFlight, Flight updatedFlight) {
        String flightString = "Flight has been updated:" + oldFlight.toString() + 
                "\nUpdated details:" + updatedFlight.toString();
        sendMessageToTopic(flightString);
    }
    
    @Override
    public void sendMessageToTopic(String flightString) {
        context.createProducer().send(flightTopic, flightString);
    }
}
