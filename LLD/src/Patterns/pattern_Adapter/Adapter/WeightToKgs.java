package Patterns.pattern_Adapter.Adapter;

import Patterns.pattern_Adapter.Adaptee.WeighingMachine;
import Patterns.pattern_Adapter.Adaptee.WeightInPounds;

public class WeightToKgs implements WeighingMachineAdapter {

    WeighingMachine weighingMachine = new WeightInPounds();

    public WeightToKgs(WeighingMachine weighingMachine){
        this.weighingMachine = weighingMachine;
    }

    @Override
    public double weightInKgs(){
        return (int) ( weighingMachine.getWeightInPounds()  * .45 );
    }
}
