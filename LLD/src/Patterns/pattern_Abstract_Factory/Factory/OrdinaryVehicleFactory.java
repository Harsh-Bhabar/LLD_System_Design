package Patterns.pattern_Abstract_Factory.Factory;

import Patterns.pattern_Abstract_Factory.Classes.*;

public class OrdinaryVehicleFactory implements CarFactory {
    @Override
    public Vehicle createVehicle(String brand) {
        if ("tata".equalsIgnoreCase(brand)) {
            return new Tata();
        } else if ("maruti".equalsIgnoreCase(brand)) {
            return new Maruti();
        } else {
            throw new IllegalArgumentException("Unknown brand: " + brand);
        }
    }
}
