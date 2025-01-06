package Problems.BMS_Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

// Entity: Show
class Show {
    private String id;
    private Screen screen;
    private Movie movie;
    private int startTime;
    private List<Integer> bookedSeats;
    private int version; // Version for optimistic locking

    public Show(String id, Screen screen, Movie movie, int startTime) {
        this.id = id;
        this.screen = screen;
        this.movie = movie;
        this.startTime = startTime;
        this.bookedSeats = new ArrayList<>();
        this.version = 0; // Initialize version
    }

    public String getId() {
        return id;
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

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public int getVersion() {
        return version;
    }

    public void incrementVersion() {
        this.version++;
    }
}

// Entity: Movie
class Movie {
    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// Entity: Screen
class Screen {
    private String name;

    public Screen(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Repository: ShowRepository (Simulates database operations)
class ShowRepository {
    private ConcurrentMap<String, Show> showDatabase = new ConcurrentHashMap<>();

    public Show getShowById(String showId) {
        return showDatabase.get(showId);
    }

    public void saveShow(Show show) {
        showDatabase.put(show.getId(), show);
    }

    public boolean updateShow(Show show, int expectedVersion) {
        Show currentShow = showDatabase.get(show.getId());
        if (currentShow.getVersion() == expectedVersion) {
            showDatabase.put(show.getId(), show);
            return true;
        }
        return false; // Version mismatch
    }
}

// Service: ShowService
class ShowService {
    private ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }

    public boolean bookSeats(String showId, List<Integer> seatsToBook, int expectedVersion) {
        Show show = showRepository.getShowById(showId);
        if (show == null) {
            throw new IllegalArgumentException("Show not found");
        }

        synchronized (show) {
            if (!show.bookSeats(seatsToBook, expectedVersion)) {
                return false; // Conflict or seat already booked
            }
            return showRepository.updateShow(show, expectedVersion);
        }
    }

    public void addShow(Show show) {
        showRepository.saveShow(show);
    }

    public Show getShowById(String showId) {
        return showRepository.getShowById(showId);
    }
}

// Controller: BookingController
class BookingController {
    private ShowService showService;

    public BookingController(ShowService showService) {
        this.showService = showService;
    }

    public boolean bookSeats(String showId, List<Integer> seatsToBook, int expectedVersion) {
        return showService.bookSeats(showId, seatsToBook, expectedVersion);
    }

    public void addShow(Show show) {
        showService.addShow(show);
    }
}

// Main: Simulate the flow
public class Main {
    public static void main(String[] args) {
        ShowRepository showRepository = new ShowRepository();
        ShowService showService = new ShowService(showRepository);
        BookingController bookingController = new BookingController(showService);

        // Create entities
        Movie movie = new Movie("Inception");
        Screen screen = new Screen("Screen 1");

        // Add a show
        Show show = new Show("show1", screen, movie, 1800);
        bookingController.addShow(show);

        // Simulate booking seats
        List<Integer> seatsToBook = List.of(1, 2, 3);
        int initialVersion = show.getVersion();

        boolean bookingResult = bookingController.bookSeats("show1", seatsToBook, initialVersion);
        System.out.println("Booking successful: " + bookingResult); // Should print true

        // Simulate another booking with outdated version
        boolean conflictBooking = bookingController.bookSeats("show1", List.of(4), initialVersion);
        System.out.println("Booking successful with outdated version: " + conflictBooking); // Should print false

        // Fetch updated show details
        Show updatedShow = showService.getShowById("show1");
        System.out.println("Updated booked seats: " + updatedShow.getBookedSeats()); // Should print [1, 2, 3]
        System.out.println("Updated version: " + updatedShow.getVersion()); // Should print 1
    }
}


