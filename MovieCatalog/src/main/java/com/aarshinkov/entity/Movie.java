package com.aarshinkov.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "MOVIES")
public class Movie implements Serializable {

    @Id
    @Column(name = "MOVIE_ID")
    @SequenceGenerator(name = "SEQ_GEN_MOVIE", sequenceName = "S_MOVIES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN_MOVIE")
    private Integer movieId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    public Movie() {
    }

    public Movie(String name, Date releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{movieId=" + movieId + ", name='" + name + "', releaseDate=" + releaseDate + '}';
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
