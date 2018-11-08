package com.aarshinkov.repository;

import com.aarshinkov.entity.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MoviesRepository extends CrudRepository<Movie, Integer> {

    Movie save(Movie movie);
    Movie findMovieByMovieId(Integer movieId);
    List<Movie> findMoviesByNameContaining(String name);
}
