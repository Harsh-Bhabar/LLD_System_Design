package Patterns.pattern_Adapter;

import Patterns.pattern_Adapter.Adaptee.WeighingMachine;
import Patterns.pattern_Adapter.Adaptee.WeightInPounds;
import Patterns.pattern_Adapter.Adapter.WeighingMachineAdapter;
import Patterns.pattern_Adapter.Adapter.WeightToKgs;

public class Main {
    public static void main(String[] args) {
        WeighingMachineAdapter weighingMachineAdapter = new WeightToKgs(new WeightInPounds());
        System.out.println(weighingMachineAdapter.weightInKgs());
    }
}
