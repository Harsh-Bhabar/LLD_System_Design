package Patterns.pattern_Strategy.Strategy;

public class AutoStrategy implements DriveStrategy{
    @Override
    public void drive(){
        System.out.println("DRIVE AUTO.");
    }
}
