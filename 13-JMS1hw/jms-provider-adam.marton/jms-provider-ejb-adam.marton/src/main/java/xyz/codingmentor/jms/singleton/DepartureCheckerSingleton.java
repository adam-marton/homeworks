package xyz.codingmentor.jms.singleton;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import xyz.codingmentor.jms.api.FlightCRUDServiceInterface;
import xyz.codingmentor.jms.api.FlightNoticeServiceInterface;
import xyz.codingmentor.jms.entity.Flight;

/**
 *
 * @author Ádám
 */
@Singleton
@Startup
public class DepartureCheckerSingleton {
    
    private FlightNoticeServiceInterface flightNoticeService;
    private FlightCRUDServiceInterface flightCRUDService;
    
    public DepartureCheckerSingleton() {
        //default constructor
    }
    
    @Inject
    public DepartureCheckerSingleton(FlightNoticeServiceInterface flightNoticeService, FlightCRUDServiceInterface flightCRUDService) {
        this.flightNoticeService = flightNoticeService;
        this.flightCRUDService = flightCRUDService;
    }
    
    @Schedule(minute = "*", hour = "*")
    public void noticeAboutFlightDeparturesSoon() {
        List<Flight> flights = flightCRUDService.getAllFlights();
        Date actualDate = new Date();
        Calendar actualPlusOneHourCalendar = new GregorianCalendar();
        actualPlusOneHourCalendar.add(Calendar.HOUR_OF_DAY, 1);
        Date actualPlusOneHourDate = actualPlusOneHourCalendar.getTime();
        for(Flight f : flights) {
            Date departureDate = f.getDeparture();
            if(departureDate.after(actualDate) && departureDate.before(actualPlusOneHourDate)) {
                String flightString = "Flight departures within one hour:" + f.toString();
                flightNoticeService.sendMessageToTopic(flightString);
            }
        }
    }
}
