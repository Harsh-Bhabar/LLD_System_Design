package Problems.Book_My_Show;

import Problems.Book_My_Show.ENUMS.PaymentStatus;

import java.util.List;

public class Booking {
    int id;
    Show show;
    List<Seat> seatList;
    PaymentStatus paymentStatus;
    User user;  // Associate booking with a user

    public Booking(int id, Show show, List<Seat> seatList, PaymentStatus paymentStatus, User user) {
        this.id = id;
        this.show = show;
        this.seatList = seatList;
        this.paymentStatus = paymentStatus;
        this.user = user;
        user.addBooking(this);  // Add this booking to the user's history
    }

    public User getUser() {
        return user;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
