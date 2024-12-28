package Problems.Book_My_Show.contoller;

import Problems.Book_My_Show.Movie;

import java.util.*;

public class MovieController {
    private final DataManager dataManager;

    public MovieController(DataManager dataManager){
        this.dataManager = dataManager;
    }

    public List<Movie> getMoviesByCity(String city) {
        return dataManager.getMoviesByCity(city);
    }

    public void addMovie(String city, Movie movie) {
        dataManager.addMovie(city, movie);
    }
}
