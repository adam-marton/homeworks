package xyz.codingmentor.jms.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.jms.entity.Flight;
import xyz.codingmentor.jms.api.FlightCRUDServiceInterface;
import xyz.codingmentor.jms.api.FlightNoticeServiceInterface;

/**
 *
 * @author Ádám
 */
@Path("/flight")
public class FlightResource {
    
    private FlightCRUDServiceInterface flightCRUDService;
    private FlightNoticeServiceInterface flightNoticeService;
    
    public FlightResource() {
        //default constructor
    }
    
    @Inject
    public FlightResource(FlightCRUDServiceInterface flightService, FlightNoticeServiceInterface flightNoticeService) {
        this.flightCRUDService = flightService;
        this.flightNoticeService = flightNoticeService;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createFlight(Flight flight) {
        flightCRUDService.createFlight(flight);
        return Response.ok(flight).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFlightById(@PathParam("id") Long flightId) {
        Flight flight = flightCRUDService.getFlightById(flightId);
        return Response.ok(flight).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateFlight(Flight flight) {
        Flight oldFlight = flightCRUDService.getFlightById(flight.getId());
        Flight updatedFlight = flightCRUDService.updateFlight(flight);
        flightNoticeService.noticeAboutUpdatedFlight(oldFlight, updatedFlight);
        return Response.ok(updatedFlight).build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteFlight(@PathParam("id") Long flightId) {
        flightNoticeService.noticeAboutDeletedFlight(flightCRUDService.getFlightById(flightId));
        flightCRUDService.deleteFlight(flightId);
        return Response.ok().build();
    }
}