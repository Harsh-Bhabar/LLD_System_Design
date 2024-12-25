package Problems.Car_Rental;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Store blrStore = new Store(new Location("BLR"), new LinkedList<Booking>(), new VehicleInventory(new LinkedList<Vehicle>()));
        Store hydStore = new Store(new Location("HYD"), new LinkedList<Booking>(), new VehicleInventory(new LinkedList<Vehicle>()));
        List<Store> stores = new LinkedList<>();
        stores.add(blrStore);
        stores.add(hydStore);

        User user1 = new User(1, "Harsh", "XYZ123");
        User user2 = new User(2, "Ayush", "XYZ123");
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        RentalSystem rentalSystem = new RentalSystem(users, stores);


    }
}
