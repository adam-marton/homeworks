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
import xyz.codingmentor.movie.entity.Movie;

/**
 *
 * @author Ádám
 */
@Path("/movie")
public class MovieCRUDResource {  
    
    private CRUDService<Movie> movieService;
    
    public MovieCRUDResource() {
        //default constructor
    }
    
    @Inject
    public MovieCRUDResource(@CRUDServiceQualifier(Entity.MOVIE) CRUDService<Movie> movieService) {
        this.movieService = movieService;
    }
        
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createMovie(Movie movie) {
        movieService.createEntity(movie);
        return Response.ok(movie).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovieById(@PathParam("id") Long id) {
        Movie movie = movieService.getEntityById(id);
        if(null != movie) {
            return Response.ok(movie).build();
        }
        return Response.noContent().build();
    }
    
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMovie(@PathParam("id") Long id, Movie movie) {
        if(id.equals(movie.getId())) {
            movieService.updateEntity(movie);
            return Response.ok(movie).build();
        }
        return Response.serverError().build();
    }
    
    @DELETE
    @Path("/{id}")
    public Response deleteMovie(@PathParam("id") Long id) {
        if(null != movieService.getEntityById(id)) {
            movieService.removeEntity(id);
            return Response.ok().build();
        }
        return Response.noContent().build();
    }
}
