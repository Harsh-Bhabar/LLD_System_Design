package Problems.Book_My_Show.contoller;

import Problems.Book_My_Show.Movie;
import Problems.Book_My_Show.Theater;

import java.util.*;

public class DataManager {
    private Map<String, List<Movie>> cityMovies = new HashMap<>();
    private Map<String, List<Theater>> cityTheaters = new HashMap<>();

    // Movies
    public List<Movie> getMoviesByCity(String city) {
        return cityMovies.getOrDefault(city, new ArrayList<>());
    }

    public void addMovie(String city, Movie movie) {
        cityMovies.putIfAbsent(city, new ArrayList<>());
        cityMovies.get(city).add(movie);
    }

    // Theaters
    public List<Theater> getTheatersByCity(String city) {
        return cityTheaters.getOrDefault(city, new ArrayList<>());
    }

    public void addTheater(String city, Theater theater) {
        cityTheaters.putIfAbsent(city, new ArrayList<>());
        cityTheaters.get(city).add(theater);
    }

}
