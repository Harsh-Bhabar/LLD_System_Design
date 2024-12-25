package Problems.Car_Rental;

import java.util.List;

public class  Store {
    int storeId;
    Location location;
    List<Booking> bookingList;
    VehicleInventory vehicleInventory;

    public Store(Location location, List<Booking> bookingList, VehicleInventory vehicleInventory) {
        this.location = location;
        this.bookingList = bookingList;
        this.vehicleInventory = vehicleInventory;
    }
}
