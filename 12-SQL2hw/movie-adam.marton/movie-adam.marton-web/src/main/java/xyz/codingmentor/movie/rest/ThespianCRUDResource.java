package xyz.codingmentor.movie.rest;

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
import xyz.codingmentor.movie.api.CRUDService;
import xyz.codingmentor.movie.api.CRUDServiceQualifier;
import xyz.codingmentor.movie.api.Entity;
import xyz.codingmentor.movie.entity.Thespian;

/**
 *
 * @author Ádám
 */
@Path("/thespian")
public class ThespianCRUDResource {
    
    private CRUDService<Thespian> thespianService;
    
    public ThespianCRUDResource() {
        //default constructor
    }
    
    @Inject
    public ThespianCRUDResource(@CRUDServiceQualifier(Entity.THESPIAN) CRUDService<Thespian> thespianService) {
        this.thespianService = thespianService;
    }
    
        
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createThespian(Thespian thespian) {
        thespianService.createEntity(thespian);
        return Response.ok(thespian).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getThespianById(@PathParam("id") Long id) {
        Thespian thespian = thespianService.getEntityById(id);
        if(null != thespian) {
            return Response.ok(thespian).build();
        }
        return Response.noContent().build();
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateThespian(@PathParam("id") Long id, Thespian thespian) {
        if(id.equals(thespian.getId())) {
            thespianService.updateEntity(thespian);
            return Response.ok(thespian).build();
        }
        return Response.serverError().build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteThespian(@PathParam("id") Long id) {
        if(null != thespianService.getEntityById(id)) {
            thespianService.removeEntity(id);
            return Response.ok().build();
        }
        return Response.noContent().build();
    }
}
