package Problems.Car_Rental;

public class Vehicle_Car extends Vehicle {

    public Vehicle_Car(int vehicleId, String vehicleName, String vehicleNumber, VehicleType vehicleType, VehicleStatus vehicleStatus, int dailyRentalCost) {
        super(vehicleId, vehicleName, vehicleNumber, VehicleType.CAR, vehicleStatus, dailyRentalCost);
    }
}

