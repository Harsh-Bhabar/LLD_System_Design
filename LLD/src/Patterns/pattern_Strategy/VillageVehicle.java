package Patterns.pattern_Strategy;

import Patterns.pattern_Strategy.Strategy.ManualStrategy;

public class VillageVehicle extends Vehicle{
    VillageVehicle(){
        super(new ManualStrategy());
    }
}
