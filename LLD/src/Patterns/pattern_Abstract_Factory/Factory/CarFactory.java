package Patterns.pattern_Abstract_Factory.Factory;

import Patterns.pattern_Abstract_Factory.Classes.Vehicle;

public interface CarFactory {
    Vehicle createVehicle(String brand);
}
