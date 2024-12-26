package Problems.pizza_shop_decorator_pattern;

public class Main {
    public static void main(String[] args){
        BasePizza basePizza = new ToppingType_2(new ToppingType_1(new PizzaType_1()));
        System.out.println(basePizza.cost());
    }
}
