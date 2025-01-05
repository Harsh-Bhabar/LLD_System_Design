package Problems.BMS_Concurrency;


import Problems.BMS_Concurrency.*;
import Problems.Book_My_Show.Booking;
import Problems.Book_My_Show.Payment;

import java.util.*;

public class BookingController {
    private final DataManager dataManager;

    public BookingController(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public Booking bookSeats(Long showId, List<Integer> seatIds, Payment payment) throws Exception {
        while (true) {
            // Fetch the show
            Show show = dataManager.getShowById(showId);
            if (show == null) {
                throw new RuntimeException("Show not found");
            }

            // Check seat availability
            for (int seatId : seatIds) {
                if (show.getBookedSeatIds().contains(seatId)) {
                    throw new RuntimeException("Seat " + seatId + " is already booked");
                }
            }

            // Optimistic locking logic
            int currentVersion = show.getVersion();

            // Create a new version of the show for updating
            Set<Integer> updatedBookedSeats = new HashSet<>(show.getBookedSeatIds());
            updatedBookedSeats.addAll(seatIds);

            Show updatedShow = new Show();
            updatedShow.setId(show.getId());
            updatedShow.setMovie(show.getMovie());
            updatedShow.setTheater(show.getTheater());
            updatedShow.setStartTime(show.getStartTime());
            updatedShow.setBookedSeatIds(updatedBookedSeats);
            updatedShow.setVersion(currentVersion + 1);

            // Try updating the show in the DataManager (mocked for simplicity)
            boolean updateSuccessful = dataManager.updateShow(showId, updatedShow, currentVersion);

            if (updateSuccessful) {
                // Create and save booking
//                Booking booking = new Booking();
//                booking.setId(System.currentTimeMillis()); // Generate unique ID
//                booking.setShow(updatedShow);
//                booking.setSeats(seatIds);
//                booking.setPayment(payment);

//                dataManager.addBooking(booking);
//                return booking;
            } else {
                // Retry in case of version mismatch
                System.out.println("Version mismatch detected. Retrying...");
            }
        }
    }
}

