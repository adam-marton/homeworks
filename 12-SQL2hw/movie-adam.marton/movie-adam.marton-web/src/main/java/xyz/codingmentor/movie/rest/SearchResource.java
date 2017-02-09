package xyz.codingmentor.movie.rest;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import xyz.codingmentor.movie.api.SearchServiceInterface;
import xyz.codingmentor.movie.entity.Movie;
import xyz.codingmentor.movie.entity.Thespian;
import xyz.codingmentor.movie.entity.Trailer;

/**
 *
 * @author Ádám
 */
@Path("/search")
@Produces(MediaType.APPLICATION_JSON)
public class SearchResource {
    
    private SearchServiceInterface searchService;
    
    public SearchResource() {
        //default constructor
    }
    
    @Inject
    public SearchResource(SearchServiceInterface searchService) {
        this.searchService = searchService;
    }
    
    @GET
    @Path("/movies")
    public Response getMoviesByTitleOrCategory(@QueryParam("title") String title, @QueryParam("categoryId") Long categoryId) {
        List<Movie> movies = searchService.getMoviesByTitleOrCategory(title, categoryId);
        return Response.ok(movies).build();
    }
    
    @GET
    @Path("/thespians")
    public Response getThespiansByNameOrMovie(@QueryParam("firstName") String firstName, 
            @QueryParam("lastName") String lastName, @QueryParam("movieId") Long movieId) {
        List<Thespian> thespians = searchService.getThespiansByNameOrMovie(firstName, lastName, movieId);
        return Response.ok(thespians).build();
    }
    
    @GET
    @Path("/thespians_nat")
    public Response getThespiansByNationality(@QueryParam("nationality") String nationality) {
        List<Thespian> thespians = searchService.getThespiansByNationality(nationality);
        return Response.ok(thespians).build();
    }
    
    @GET
    @Path("/trailers")
    public Response getTrailersByMovie(@QueryParam("movieId") Long movieId) {
        List<Trailer> trailers = searchService.getTrailersByMovie(movieId);
        return Response.ok(trailers).build();
    }
}
