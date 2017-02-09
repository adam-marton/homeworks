package xyz.codingmentor.movie.rest;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import xyz.codingmentor.movie.api.JoinServiceInterface;

/**
 *
 * @author Ádám
 */
@Path("/join")
public class JoinResource {
    
    private JoinServiceInterface joinService;
    
    public JoinResource() {
        //default constructor
    }
    
    @Inject
    public JoinResource(JoinServiceInterface joinService) {
        this.joinService = joinService;
    }
    
    @POST
    @Path("/thespian")
    public Response joinMovieAndThespian(@QueryParam("movieId") Long movieId, @QueryParam("thespianId") Long thespianId) {
        joinService.joinMovieAndThespian(movieId, thespianId);
        return Response.ok().build();
    }
    
    @POST
    @Path("/trailer")
    public Response joinMovieAndTrailer(@QueryParam("movieId") Long movieId, @QueryParam("trailerId") Long trailerId) {
        joinService.joinMovieAndTrailer(movieId, trailerId);
        return Response.ok().build();
    }
    
    @POST
    @Path("/category")
    public Response joinMovieAndCategory(@QueryParam("movieId") Long movieId, @QueryParam("categoryId") Long categoryId) {
        joinService.joinMovieAndCategory(movieId, categoryId);
        return Response.ok().build();
    }
}
