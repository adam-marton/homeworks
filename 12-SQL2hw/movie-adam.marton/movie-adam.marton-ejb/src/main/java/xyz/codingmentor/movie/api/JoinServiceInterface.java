package xyz.codingmentor.movie.api;

/**
 *
 * @author Ádám
 */
public interface JoinServiceInterface {
    
    void joinMovieAndThespian(Long movieId, Long thespianId);
        
    void joinMovieAndTrailer(Long movieId, Long trailerId);
        
    void joinMovieAndCategory(Long movieId, Long categoryId);
}
