package com.aarshinkov.services;

import com.aarshinkov.entity.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesServicesImpl implements MoviesServices {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Movie> getMoviesList() {

        List<Movie> movies = new ArrayList<>();

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareCall("SELECT * FROM MOVIES ORDER BY 1 DESC");
            ResultSet resultSet = pst.executeQuery();

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setMovieId(resultSet.getInt(1));
                movie.setName(resultSet.getString(2));
                movie.setReleaseDate(resultSet.getDate(3));

                movies.add(movie);
            }
        } catch (SQLException e) {
            log.error("An error occurred while getting movies list", e);
        }

        return movies;
    }

    @Override
    public void deleteMovie(Integer movieId) {
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pst = conn.prepareCall("DELETE FROM MOVIES WHERE MOVIE_ID = ?");
            pst.setInt(1, movieId);
            pst.execute();

            log.debug("Movie with id = " + movieId + " successfully deleted --");

        } catch (SQLException e) {
            log.error("An error occurred while trying to delete movie with id = " + movieId, e);
        }
    }
}
