package Problems.Book_My_Show;

import Problems.Book_My_Show.ENUMS.ScreenType;
import Problems.Book_My_Show.ENUMS.SeatType;
import Problems.Book_My_Show.ENUMS.PaymentStatus;
import Problems.Book_My_Show.ENUMS.PaymentType;
import Problems.Book_My_Show.contoller.DataManager;
import Problems.Book_My_Show.contoller.MovieController;
import Problems.Book_My_Show.contoller.TheaterController;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Initialize the centralized DataManager
        DataManager dataManager = new DataManager();

        // Initialize the controllers
        MovieController movieController = new MovieController(dataManager);
        TheaterController theaterController = new TheaterController(dataManager);

        // Cities
        City bangalore = new City("Bengaluru");
        City newYork = new City("New York");

        // Add Movies to the system
        Movie movie1 = new Movie(1, "Inception", 148);
        Movie movie2 = new Movie(2, "Interstellar", 169);
        Movie movie3 = new Movie(3, "Avengers", 220);

        movieController.addMovie(newYork.getName(), movie1);
        movieController.addMovie(newYork.getName(), movie2);
        movieController.addMovie(bangalore.getName(), movie2);
        movieController.addMovie(bangalore.getName(), movie3);

        // Add Theaters to the system
        Theater theater1 = new Theater(1, "Regal Cinemas", "123 Main St, New York");
        Theater theater2 = new Theater(2, "AMC Empire", "456 Broadway, New York");
        Theater theater3 = new Theater(3, "Phoenix", "Whitefield");
        Theater theater4 = new Theater(4, "Lulu", "Whitefield");

        theaterController.addTheater(newYork.getName(), theater1);
        theaterController.addTheater(newYork.getName(), theater2);
        theaterController.addTheater(bangalore.getName(), theater3);
        theaterController.addTheater(bangalore.getName(), theater4);

        // Display Movies for a City
        System.out.println("Movies in New York:");
        movieController.getMoviesByCity("New York").forEach(movie ->
                System.out.println(movie.getName())
        );

        // Display Theaters for a City
        System.out.println("\nTheaters in Bengaluru:");
        theaterController.getTheatersByCity("Bengaluru").forEach(theater ->
                System.out.println(theater.getName())
        );

        // Create Shows for the Theaters
        Screen screen1 = new Screen(ScreenType.INOX, 100, new ArrayList<>());
        Screen screen2 = new Screen(ScreenType.FOUR_DX, 150, new ArrayList<>());
        Show show1 = new Show(screen1, movie1, 1200, new ArrayList<>());
        Show show2 = new Show(screen2, movie2, 1400, new ArrayList<>());

        theater1.screens.add(screen1);
        theater2.screens.add(screen2);

        screen1.showList.add(show1);
        screen2.showList.add(show2);

        // Display Shows for a Theater
        System.out.println("\nShows in Regal Cinemas:");
        theater1.getScreens().forEach(screen ->
                screen.showList.forEach(show ->
                        System.out.println(show.movie.getName() + " at " + show.startTime)
                )
        );

        // Two users try to book the same seats simultaneously
        User user = new User(1, "John Doe", "johndoe@example.com", "1234567890");
        User user2 = new User(2, "Harsh", "hb@gmail.com", "1234567890");

        // Same seats for both bookings
        Seat seat1 = new Seat(SeatType.NORMAL, 10, 1);
        Seat seat2 = new Seat(SeatType.NORMAL, 12, 2);
        List<Seat> seatList = Arrays.asList(seat1, seat2);

        // Both users create bookings for the same show and seats
        Booking booking = new Booking(1, show1, seatList, PaymentStatus.PENDING, user);
        Booking booking2 = new Booking(2, show1, seatList, PaymentStatus.PENDING, user2);

        // Process payment for both bookings
        Payment payment1 = new Payment(1, PaymentStatus.PENDING, PaymentType.CREDIT_CARD);
        Payment payment2 = new Payment(2, PaymentStatus.PENDING, PaymentType.CREDIT_CARD);

        // Both payments succeed (simulating a race condition)
        if (payment1.processPayment()) {
            booking.setPaymentStatus(PaymentStatus.SUCCESS);
        }

        if (payment2.processPayment()) {
            booking2.setPaymentStatus(PaymentStatus.SUCCESS);
        }

        // Display both bookings
        System.out.println("\nBooking 1 Details:");
        System.out.println("User: " + booking.getUser().getName());
        System.out.println("Seats: ");
        booking.getSeatList().forEach(seat ->
                System.out.println("Seat ID: " + seat.getId() + ", Price: " + seat.getPrice())
        );

        System.out.println("\nBooking 2 Details:");
        System.out.println("User: " + booking2.getUser().getName());
        System.out.println("Seats: ");
        booking2.getSeatList().forEach(seat ->
                System.out.println("Seat ID: " + seat.getId() + ", Price: " + seat.getPrice())
        );
    }
}
