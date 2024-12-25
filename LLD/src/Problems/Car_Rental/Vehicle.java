package Problems.Car_Rental;

public class Vehicle {
    int vehicleId;
    String vehicleName;
    String vehicleNumber;
    VehicleType vehicleType;
    VehicleStatus vehicleStatus;
    int dailyRentalCost;

    public Vehicle(int vehicleId, String vehicleName, String vehicleNumber, VehicleType vehicleType, VehicleStatus vehicleStatus, int dailyRentalCost) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.vehicleStatus = vehicleStatus;
        this.dailyRentalCost = dailyRentalCost;
    }

    public VehicleStatus getVehicleStatus() {
        return  this.vehicleStatus;
    }
}
