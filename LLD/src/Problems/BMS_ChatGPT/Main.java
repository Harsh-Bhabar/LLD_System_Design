package Problems.BMS_ChatGPT;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
}

enum SeatType { REGULAR, PREMIUM, RECLINER }
enum PaymentStatus { PENDING, SUCCESS, FAILED }
enum PaymentType { CREDIT_CARD, DEBIT_CARD, UPI, CASH }
enum ScreenType { STANDARD, IMAX, FOUR_DX }

class Seat {
    private int id;
    private SeatType type;
    private double price;
    private boolean isBooked;
    private int version;

    public Seat(int id, SeatType type, double price) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.isBooked = false;
        this.version = 0;
    }

    public synchronized boolean book(int expectedVersion) {
        if (isBooked || this.version != expectedVersion) {
            return false;
        }
        isBooked = true;
        version++;
        return true;
    }

    public int getVersion() {
        return version;
    }

    public int getId() {
        return id;
    }
}

class Show {
    private int id;
    private List<Seat> seats;

    public Show(int id, int seatCount) {
        this.id = id;
        this.seats = new ArrayList<>();
        for (int i = 1; i <= seatCount; i++) {
            seats.add(new Seat(i, SeatType.REGULAR, 150));
        }
    }

    public List<Seat> getSeats() {
        return seats;
    }
}

class BookingSystem {
    public static void main(String[] args) {
        Show show = new Show(1, 10);

        // Simulate concurrent bookings
        Thread user1 = new Thread(() -> simulateBooking(show, 1));
        Thread user2 = new Thread(() -> simulateBooking(show, 1));

        user1.start();
        user2.start();

        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void simulateBooking(Show show, int seatId) {
        List<Seat> seats = show.getSeats();
        Seat seat = seats.get(seatId - 1);

        for (int attempt = 0; attempt < 3; attempt++) {
            if (seat.book(seat.getVersion())) {
                System.out.println(Thread.currentThread().getName() + " successfully booked Seat " + seatId);
                return;
            } else {
                System.out.println(Thread.currentThread().getName() + " failed to book Seat " + seatId + " (version mismatch). Retrying...");
            }
        }
    }
}

