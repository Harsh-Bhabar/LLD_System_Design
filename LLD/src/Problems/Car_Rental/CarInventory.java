package Problems.Car_Rental;

import java.util.ArrayList;
import java.util.List;

public class CarInventory extends VehicleInventory{
    public CarInventory(List<Vehicle_Car> carList){
        super(new ArrayList<>(carList));
    }
}
