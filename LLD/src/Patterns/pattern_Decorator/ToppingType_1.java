package Patterns.pattern_Decorator;

public class ToppingType_1 extends Toppings{
    BasePizza basePizza;

    public ToppingType_1(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost(){
        return basePizza.cost() + 25;
    }
}
