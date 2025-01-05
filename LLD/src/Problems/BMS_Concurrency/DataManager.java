package Problems.BMS_Concurrency;

import Problems.Book_My_Show.Booking;
import Problems.Book_My_Show.Movie;
import Problems.Book_My_Show.Theater;

import java.util.*;
public class DataManager {
    private Map<String, List<Movie>> cityMovies = new HashMap<>();
    private Map<String, List<Theater>> cityTheaters = new HashMap<>();
    private Map<Long, Show> showMap = new HashMap<>();
    private Map<Long, Booking> bookingMap = new HashMap<>();

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

    // Shows
    public void addShow(Show show) {
        showMap.put(show.getId(), show);
    }

    public Show getShowById(Long showId) {
        return showMap.get(showId);
    }

    // Bookings
    public void addBooking(Booking booking) {
//        bookingMap.put(booking.getId(), booking);
    }

    public Booking getBookingById(Long bookingId) {
        return bookingMap.get(bookingId);
    }
}

