package Problems.Book_My_Show;

import java.util.List;

public class Show {
    String id;
    Screen screen;
    Movie movie;
    int startTime;
    List<Integer> bookedSeats;
    private int version; // Version for optimistic locking

    public Show(Screen screen, Movie movie, int startTime, List<Integer> bookedSeats) {
        this.screen = screen;
        this.movie = movie;
        this.startTime = startTime;
        this.bookedSeats = bookedSeats;
        this.version = 0; // Initialize version
    }

    public synchronized boolean bookSeats(List<Integer> seatsToBook, int expectedVersion) {
        if (this.version != expectedVersion) {
            // Conflict detected
            return false;
        }
        for (Integer seat : seatsToBook) {
            if (bookedSeats.contains(seat)) {
                // Seat already booked
                return false;
            }
        }
        bookedSeats.addAll(seatsToBook);
        this.version++; // Increment version after successful booking
        return true;
    }

    public int getVersion() {
        return this.version;
    }
}
