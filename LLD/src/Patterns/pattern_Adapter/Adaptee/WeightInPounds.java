package Patterns.pattern_Adapter.Adaptee;

public class WeightInPounds implements WeighingMachine {

    @Override
    public double getWeightInPounds(){
        return 28;
    }
}
