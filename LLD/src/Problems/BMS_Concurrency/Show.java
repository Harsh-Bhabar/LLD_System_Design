package Problems.BMS_Concurrency;

import Problems.Book_My_Show.*;

import java.util.*;

public class Show {
    private Long id;
    private Movie movie;
    private Theater theater;
    private String startTime;
    private Set<Integer> bookedSeatIds = new HashSet<>();
    private int version; // Version for optimistic locking

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Set<Integer> getBookedSeatIds() {
        return bookedSeatIds;
    }

    public void setBookedSeatIds(Set<Integer> bookedSeatIds) {
        this.bookedSeatIds = bookedSeatIds;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}

