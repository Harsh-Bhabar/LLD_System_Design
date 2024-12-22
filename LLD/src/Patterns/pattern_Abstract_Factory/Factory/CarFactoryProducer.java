package Patterns.pattern_Abstract_Factory.Factory;

public class CarFactoryProducer {
    public static CarFactory getCarFactory(String type) {
        if ("ordinary".equalsIgnoreCase(type)) {
            return new OrdinaryVehicleFactory();
        }
        if("ordinary".equalsIgnoreCase(type)){
            return new OrdinaryVehicleFactory();
        }
        else {
            throw new IllegalArgumentException("Unknown factory type: " + type);
        }
    }
}
