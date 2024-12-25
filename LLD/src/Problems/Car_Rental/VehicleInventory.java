package Problems.Car_Rental;

import java.util.*;

public class VehicleInventory {
    List<Vehicle> vehicles;

    public VehicleInventory(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getVehicleStatus() == VehicleStatus.AVAILABLE) {
                availableVehicles.add(v);
            }
        }
        return availableVehicles;
    }
}
