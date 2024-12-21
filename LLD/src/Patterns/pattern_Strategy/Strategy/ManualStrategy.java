package Patterns.pattern_Strategy.Strategy;

public class ManualStrategy implements DriveStrategy{
    @Override
    public void drive(){
        System.out.println("MANUAL DRIVE.");
    }
}
