package Patterns.pattern_Strategy;

import Patterns.pattern_Strategy.Strategy.DriveStrategy;

public class Vehicle {
    DriveStrategy driveStrategy;

    Vehicle(DriveStrategy obj){
        this.driveStrategy = obj;
    }

    public void drive(){
        driveStrategy.drive();
    }
}
