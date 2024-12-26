package Problems.pizza_shop_decorator_pattern;

public class ToppingType_2 extends Toppings {
    BasePizza basePizza;

    public ToppingType_2(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost(){
        return basePizza.cost() + 22;
    }
}
