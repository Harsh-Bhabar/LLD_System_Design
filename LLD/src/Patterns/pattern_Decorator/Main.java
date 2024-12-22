package Patterns.pattern_Decorator;

public class Main {
    public static void main(String[] args){
        BasePizza basePizza = new ToppingType_2(new ToppingType_1(new PizzaType_1()));
        System.out.println(basePizza.cost());
    }
}
