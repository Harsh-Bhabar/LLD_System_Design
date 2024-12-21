package Patterns.pattern_Strategy;

import Patterns.pattern_Strategy.Strategy.AutoStrategy;
import Patterns.pattern_Strategy.Strategy.DriveStrategy;
import Patterns.pattern_Strategy.Strategy.ManualStrategy;

public class Main {
    public static void main(String[] args){
        Vehicle city = new Vehicle(new AutoStrategy());
        Vehicle village = new Vehicle(new ManualStrategy());

        city.drive();
        village.drive();

     }
}
