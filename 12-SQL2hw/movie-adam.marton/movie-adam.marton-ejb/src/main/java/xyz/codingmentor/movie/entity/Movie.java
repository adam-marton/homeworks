package xyz.codingmentor.movie.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ádám
 */
@Entity
public class Movie implements Serializable {
    
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "jnd_mov_thesp",
            joinColumns = @JoinColumn(name = "movie_fk"),
            inverseJoinColumns = @JoinColumn(name = "thespian_fk"))
    private List<Thespian> thespians;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST)
    private List<Trailer> trailers;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    public Movie() {
        //default constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public List<Thespian> getThespians() {
        return thespians;
    }

    public void setThespians(List<Thespian> thespians) {
        this.thespians = thespians;
    }

    @XmlTransient
    public List<Trailer> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    public void addThespian(Thespian thespian) {
        thespians.add(thespian);
    }
    
    public void addTrailer(Trailer trailer) {
        trailers.add(trailer);
    }
}
