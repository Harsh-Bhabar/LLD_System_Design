package Problems.Car_Rental;

import java.util.List;

public class RentalSystem {
    List<User> userList;
    List<Store> storeList;

    public RentalSystem(List<User> userList, List<Store> storeList) {
        this.userList = userList;
        this.storeList = storeList;
    }
}
