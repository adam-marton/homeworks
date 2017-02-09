package xyz.codingmentor.movie.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import xyz.codingmentor.movie.api.SearchRepositoryInterface;
import xyz.codingmentor.movie.api.SearchServiceInterface;
import xyz.codingmentor.movie.entity.Movie;
import xyz.codingmentor.movie.entity.Thespian;
import xyz.codingmentor.movie.entity.Trailer;

/**
 *
 * @author Ádám
 */
@Stateless
public class SearchService implements SearchServiceInterface {
    
    private SearchRepositoryInterface searchRepository;  
    
    public SearchService() {
        //default constructor
    }
    
    @Inject
    public SearchService(SearchRepositoryInterface searchRepository) {
        this.searchRepository = searchRepository;
    }
    
    @Override
    public List<Movie> getMoviesByTitleOrCategory(String title, Long categoryId) {
        boolean isTitleNull = null == title;
        boolean isCategoryIdNull = null == categoryId;
        if(!isTitleNull) {
            if(!isCategoryIdNull) {
                return searchRepository.getMoviesByTitleAndCategory(title, categoryId);
            } else {
                return searchRepository.getMoviesByTitle(title);
            }
        } else {
            if(!isCategoryIdNull) {
                return searchRepository.getMoviesByCategory(categoryId);
            }
        }
        throw new IllegalStateException("Parameter is invalid!");
    }

    @Override
    public List<Thespian> getThespiansByNameOrMovie(String firstName, String lastName, Long movieId) {
        boolean namesNotNull = null != firstName && null != lastName;
        boolean isMovieIdNull = null == movieId;
        if(namesNotNull) {
            if(!isMovieIdNull) {
                return searchRepository.getThespiansByNameAndMovie(firstName, lastName, movieId);
            } else {
                return searchRepository.getThespiansByName(firstName, lastName);
            }
        } else {
            if(!isMovieIdNull) {
                return searchRepository.getThespiansByMovie(movieId);
            }
        }
        throw new IllegalStateException("Parameter is invalid!");
    }

    @Override
    public List<Thespian> getThespiansByNationality(String nationality) {
        return searchRepository.getThespiansByNationality(nationality);
    }

    @Override
    public List<Trailer> getTrailersByMovie(Long movieId) {
        return searchRepository.getTrailersByMovie(movieId);
    }
}
