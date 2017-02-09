package xyz.codingmentor.movie.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Ádám
 */
@Entity
public class Trailer implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private String url;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String title;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date publicationDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "movie_fk")
    private Movie movie;

    public Trailer() {
        //default constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
