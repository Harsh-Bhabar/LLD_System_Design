package Problems.Car_Rental;

import java.util.ArrayList;
import java.util.List;

public class BikeInventory extends VehicleInventory{
    BikeInventory(List<Vehicle_Bike> vehicleBikes){
        super(new ArrayList<>(vehicleBikes));
    }
}
