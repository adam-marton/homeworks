package xyz.codingmentor.jms.listener;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author Ádám
 */
@MessageDriven(mappedName = "jms/flightTopic")
public class FlightListener implements MessageListener {
 
    private static final Logger LOGGER = Logger.getLogger(FlightListener.class.getName());
    
    public FlightListener() {
        //default constructor
    }

    @Override
    public void onMessage(Message message) {
        try {
            LOGGER.log(Level.INFO, message.getBody(String.class));
        } catch (JMSException ex) {
            Logger.getLogger(FlightListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}