package xyz.codingmentor.movie.api;

import java.util.List;
import xyz.codingmentor.movie.entity.Movie;
import xyz.codingmentor.movie.entity.Thespian;
import xyz.codingmentor.movie.entity.Trailer;

/**
 *
 * @author Ádám
 */
public interface SearchRepositoryInterface {
    
    List<Movie> getMoviesByTitleAndCategory(String title, Long categoryId);
    
    List<Movie> getMoviesByTitle(String title);
    
    List<Movie> getMoviesByCategory(Long categoryId);
    
    List<Thespian> getThespiansByNameAndMovie(String firstName, String lastName, Long movieId);
  
    List<Thespian> getThespiansByName(String firstName, String lastName);
    
    List<Thespian> getThespiansByMovie(Long movieId);
    
    List<Thespian> getThespiansByNationality(String nationality);
    
    List<Trailer> getTrailersByMovie(Long movieId);
}
