package xyz.codingmentor.movie.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.movie.api.CRUDService;
import xyz.codingmentor.movie.api.CRUDServiceQualifier;
import xyz.codingmentor.movie.api.Entity;
import xyz.codingmentor.movie.api.JoinServiceInterface;
import xyz.codingmentor.movie.entity.Category;
import xyz.codingmentor.movie.entity.Movie;
import xyz.codingmentor.movie.entity.Thespian;
import xyz.codingmentor.movie.entity.Trailer;

/**
 *
 * @author Ádám
 */
@Stateless
public class JoinService implements JoinServiceInterface {
    
    private static final String ENTITY_NOT_EXIST = "Entity does not exist!";
    private CRUDService<Category> categoryCRUDService;
    private CRUDService<Movie> movieCRUDService;
    private CRUDService<Thespian> thespianCRUDService;
    private CRUDService<Trailer> trailerCRUDService;
    
    public JoinService() {
        //default constructor
    }
    
    @Inject
    public JoinService(@CRUDServiceQualifier(Entity.CATEGORY) CRUDService<Category> categoryCRUDService, 
            @CRUDServiceQualifier(Entity.MOVIE) CRUDService<Movie> movieCRUDService, 
            @CRUDServiceQualifier(Entity.THESPIAN) CRUDService<Thespian> thespianCRUDService, 
            @CRUDServiceQualifier(Entity.TRAILER) CRUDService<Trailer> trailerCRUDService) {
        this.categoryCRUDService = categoryCRUDService;
        this.movieCRUDService = movieCRUDService;
        this.thespianCRUDService = thespianCRUDService;
        this.trailerCRUDService = trailerCRUDService;
    }
    
    @Override
    public void joinMovieAndThespian(Long movieId, Long thespianId) {
        Movie movie = movieCRUDService.getEntityById(movieId);
        Thespian thespian = thespianCRUDService.getEntityById(thespianId);
        if(null == movie || null == thespian) {
            throw new IllegalStateException(ENTITY_NOT_EXIST);
        }
        movie.addThespian(thespian);
        thespian.addMovie(movie);
        movieCRUDService.updateEntity(movie);
        thespianCRUDService.updateEntity(thespian);
    }
    
    @Override
    public void joinMovieAndTrailer(Long movieId, Long trailerId) {
        Movie movie = movieCRUDService.getEntityById(movieId);
        Trailer trailer = trailerCRUDService.getEntityById(trailerId);
        if(null == movie || null == trailer) {
            throw new IllegalStateException(ENTITY_NOT_EXIST);
        }
        movie.addTrailer(trailer);
        trailer.setMovie(movie);
        movieCRUDService.updateEntity(movie);
        trailerCRUDService.updateEntity(trailer);
    }
    
    @Override
    public void joinMovieAndCategory(Long movieId, Long categoryId) {
        Movie movie = movieCRUDService.getEntityById(movieId);
        Category category = categoryCRUDService.getEntityById(categoryId);
        if(null == movie || null == category) {
            throw new IllegalStateException(ENTITY_NOT_EXIST);
        }
        movie.setCategory(category);
        category.addMovie(movie);
        movieCRUDService.updateEntity(movie);
        categoryCRUDService.updateEntity(category);
    }
}
