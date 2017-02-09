package xyz.codingmentor.movie.repository;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import xyz.codingmentor.movie.api.SearchRepositoryInterface;
import xyz.codingmentor.movie.entity.Movie;
import xyz.codingmentor.movie.entity.Thespian;
import xyz.codingmentor.movie.entity.Trailer;

/**
 *
 * @author Ádám
 */
@Stateless
public class SearchRepository implements SearchRepositoryInterface {
    
    private static final String MOVIE_ID = "movieId";
    @PersistenceContext(unitName = "moviePU")
    private EntityManager entityManager;

    @Override
    public List<Movie> getMoviesByTitleAndCategory(String title, Long categoryId) {
        String selectQuery = "SELECT m FROM Movie m JOIN m.category c WHERE m.title LIKE :title AND c.id=:categoryId";
        TypedQuery<Movie> query = entityManager.createQuery(selectQuery, Movie.class);
        query.setParameter("title", "%" + title + "%");
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    @Override
    public List<Movie> getMoviesByTitle(String title) {
        String selectQuery = "SELECT m FROM Movie m WHERE m.title LIKE :title";
        TypedQuery<Movie> query = entityManager.createQuery(selectQuery, Movie.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }

    @Override
    public List<Movie> getMoviesByCategory(Long categoryId) {
        String selectQuery = "SELECT m FROM Movie m JOIN m.category c WHERE c.id=:categoryId";
        TypedQuery<Movie> query = entityManager.createQuery(selectQuery, Movie.class);
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    @Override
    public List<Thespian> getThespiansByNameAndMovie(String firstName, String lastName, Long movieId) {
        String selectQuery = "SELECT t FROM Thespian t JOIN t.movies m WHERE t.firstName LIKE :firstName AND t.lastName LIKE :lastName AND m.id=:movieId";
        TypedQuery<Thespian> query = entityManager.createQuery(selectQuery, Thespian.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        query.setParameter(MOVIE_ID, movieId);
        return query.getResultList();
    }

    @Override
    public List<Thespian> getThespiansByName(String firstName, String lastName) {
        String selectQuery = "SELECT t FROM Thespian t WHERE t.firstName LIKE :firstName AND t.lastName LIKE :lastName";
        TypedQuery<Thespian> query = entityManager.createQuery(selectQuery, Thespian.class);
        query.setParameter("firstName", firstName);      
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public List<Thespian> getThespiansByMovie(Long movieId) {
        String selectQuery = "SELECT t FROM Thespian t JOIN t.movies m WHERE m.id=:movieId";
        TypedQuery<Thespian> query = entityManager.createQuery(selectQuery, Thespian.class);
        query.setParameter(MOVIE_ID, movieId);
        return query.getResultList();
    }

    @Override
    public List<Thespian> getThespiansByNationality(String nationality) {
        String selectQuery = "SELECT t FROM Thespian t WHERE t.nationality LIKE :nationality";
        TypedQuery<Thespian> query = entityManager.createQuery(selectQuery, Thespian.class);
        query.setParameter("nationality", nationality);
        return query.getResultList();
    }

    @Override
    public List<Trailer> getTrailersByMovie(Long movieId) {
        String selectQuery = "SELECT t FROM Trailer t JOIN t.movie m WHERE m.id=:movieId";
        TypedQuery<Trailer> query = entityManager.createQuery(selectQuery, Trailer.class);
        query.setParameter(MOVIE_ID, movieId);
        return query.getResultList();
    }
}
