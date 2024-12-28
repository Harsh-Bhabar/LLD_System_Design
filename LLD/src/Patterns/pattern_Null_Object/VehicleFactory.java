package Patterns.pattern_Null_Object;

public class VehicleFactory {
    Vehicle getVehicle(String vehicle){
        if("car".equalsIgnoreCase(vehicle)){
            return new Car();
        }
        return new Null();
    }
}
