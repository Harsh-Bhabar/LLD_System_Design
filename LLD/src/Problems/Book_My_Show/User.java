package Problems.Book_My_Show;

import java.util.*;

public class User {
    private int id;
    private String name;
    private String email;
    private String phone;
    private List<Booking> bookingHistory;

    public User(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.bookingHistory = new ArrayList<>();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<Booking> getBookingHistory() {
        return bookingHistory;
    }

    // Method to add a booking to the user's history
    public void addBooking(Booking booking) {
        this.bookingHistory.add(booking);
    }
}

