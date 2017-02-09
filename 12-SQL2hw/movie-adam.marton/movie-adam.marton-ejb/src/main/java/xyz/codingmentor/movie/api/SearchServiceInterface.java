package xyz.codingmentor.movie.api;

import java.util.List;
import xyz.codingmentor.movie.entity.Movie;
import xyz.codingmentor.movie.entity.Thespian;
import xyz.codingmentor.movie.entity.Trailer;

/**
 *
 * @author Ádám
 */
public interface SearchServiceInterface {
    
    List<Movie> getMoviesByTitleOrCategory(String title, Long categoryId);
    
    List<Thespian> getThespiansByNameOrMovie(String firstName, String lastName, Long movieId);
    
    List<Thespian> getThespiansByNationality(String nationality);
    
    List<Trailer> getTrailersByMovie(Long movieId);
}
