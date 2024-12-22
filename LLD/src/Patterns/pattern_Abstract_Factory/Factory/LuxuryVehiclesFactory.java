package Patterns.pattern_Abstract_Factory.Factory;

import Patterns.pattern_Abstract_Factory.Classes.BMW;
import Patterns.pattern_Abstract_Factory.Classes.Mercedes;
import Patterns.pattern_Abstract_Factory.Classes.Vehicle;

public class LuxuryVehiclesFactory implements CarFactory{
    @Override
    public Vehicle createVehicle(String brand) {
        if ("bmw".equalsIgnoreCase(brand)) {
            return new BMW();
        } else if ("mercedes".equalsIgnoreCase(brand)) {
            return new Mercedes();
        } else {
            throw new IllegalArgumentException("Unknown brand: " + brand);
        }
    }
}
