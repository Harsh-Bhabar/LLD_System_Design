package Problems.Book_My_Show;

import Problems.Book_My_Show.ENUMS.SeatType;

public class Seat {
    int id;
    int price;
    SeatType seatType;

    public Seat(SeatType seatType, int price, int id) {
        this.seatType = seatType;
        this.price = price;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
