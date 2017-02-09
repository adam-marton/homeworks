package xyz.codingmentor.movie.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ádám
 */
@Entity
public class Thespian implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String nationality;
    @ManyToMany(mappedBy = "thespians", cascade = CascadeType.PERSIST)
    private List<Movie> movies;

    public Thespian() {
        //default constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @XmlTransient
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}
