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
import xyz.codingmentor.movie.entity.Trailer;

/**
 *
 * @author Ádám
 */
@Path("/trailer")
public class TrailerCRUDResource {
    
    private CRUDService<Trailer> trailerService;
    
    public TrailerCRUDResource() {
        //default constructor
    }
    
    @Inject
    public TrailerCRUDResource(@CRUDServiceQualifier(Entity.TRAILER) CRUDService<Trailer> trailerService) {
        this.trailerService = trailerService;
    }
        
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTrailer(Trailer trailer) {
        trailerService.createEntity(trailer);
        return Response.ok(trailer).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrailerById(@PathParam("id") Long id) {
        Trailer trailer = trailerService.getEntityById(id);
        if(null != trailer) {
            return Response.ok(trailer).build();
        }
        return Response.noContent().build();
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateTrailer(@PathParam("id") Long id, Trailer trailer) {
        if(id.equals(trailer.getId())) {
            trailerService.updateEntity(trailer);
            return Response.ok(trailer).build();
        }
        return Response.serverError().build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteTrailer(@PathParam("id") Long id) {
        if(null != trailerService.getEntityById(id)) {
            trailerService.removeEntity(id);
            return Response.ok().build();
        }
        return Response.noContent().build();
    }
}
