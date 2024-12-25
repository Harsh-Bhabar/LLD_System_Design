package Problems.Car_Rental;

public class Vehicle_Bike extends Vehicle {

    public Vehicle_Bike(int vehicleId, String vehicleName, String vehicleNumber, VehicleType vehicleType, VehicleStatus vehicleStatus, int dailyRentalCost) {
        super(vehicleId, vehicleName, vehicleNumber, VehicleType.BIKE, vehicleStatus, dailyRentalCost);
    }
}

