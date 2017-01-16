package xyz.codingmentor.asynchronous.entity;

import java.util.Objects;

/**
 *
 * @author Ádám
 */
public class BookEntity {
    private String id;
    private String author;
    private String title;
    private Integer numberOfPages;

    public BookEntity() {
        //default constructor
    }

    public BookEntity(String id, String author, String title, Integer numberOfPages) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.numberOfPages = numberOfPages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.author);
        hash = 17 * hash + Objects.hashCode(this.title);
        hash = 17 * hash + Objects.hashCode(this.numberOfPages);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BookEntity other = (BookEntity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.numberOfPages, other.numberOfPages)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BookEntity{" + "id=" + id + ", author=" + author + ", title=" + title + ", numberOfPages=" + numberOfPages + '}';
    }
}
