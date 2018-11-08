package com.aarshinkov.services;

import com.aarshinkov.entity.Movie;

import java.util.List;

public interface MoviesServices {
    List<Movie> getMoviesList();
    void deleteMovie(Integer movieId);
}
