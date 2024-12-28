package Patterns.pattern_Null_Object;

public class Main {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle vehicle1 = vehicleFactory.getVehicle("car");
        System.out.println(vehicle1.getName());
        Vehicle vehicle2 = vehicleFactory.getVehicle("bike");
        System.out.println(vehicle2.getName());
    }
}
