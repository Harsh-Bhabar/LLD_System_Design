package Problems.Car_Rental;

public class Booking {
    int bookingId;
    User user;
    Vehicle vehicle;
    int bookingStartDate;
    int bookingEndDate;

    public Booking(int bookingId, User user, Vehicle vehicle, int bookingStartDate, int bookingEndDate) {
        this.bookingId = bookingId;
        this.user = user;
        this.vehicle = vehicle;
        this.bookingStartDate = bookingStartDate;
        this.bookingEndDate = bookingEndDate;
    }
}
