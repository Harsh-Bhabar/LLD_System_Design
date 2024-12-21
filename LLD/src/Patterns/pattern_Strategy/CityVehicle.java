package Patterns.pattern_Strategy;

import Patterns.pattern_Strategy.Strategy.AutoStrategy;

public class CityVehicle extends Vehicle{
    CityVehicle(){
        super(new AutoStrategy());
    }
}
