package Patterns.pattern_Abstract_Factory;

import Patterns.pattern_Abstract_Factory.Classes.*;
import Patterns.pattern_Abstract_Factory.Factory.CarFactory;
import Patterns.pattern_Abstract_Factory.Factory.CarFactoryProducer;

public class Main {
    public static void main(String[] args) {
        // Get Ordinary Vehicle Factory
        CarFactory ordinaryCarFactory = CarFactoryProducer.getCarFactory("ordinary");

        // Create a Tata vehicle
        Vehicle tata = ordinaryCarFactory.createVehicle("tata");
        tata.manufacturer();

        // Create a Maruti vehicle
        Vehicle maruti = ordinaryCarFactory.createVehicle("maruti");
        maruti.manufacturer();
    }
}