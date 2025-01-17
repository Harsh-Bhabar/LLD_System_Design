package Problems.Food_Delivery_System.Core_Functionalities;

import Problems.Food_Delivery_System.Core_Classes.*;

import java.util.*;

public class OrderService {
    public HashMap<Integer, Order> orders = new HashMap<>();
    private int orderCounter = 0;

    public Order placeOrder(User user, Restaurant restaurant, List<OrderItem> items) {
        orderCounter++;
        Order order = new Order(orderCounter, user, restaurant, items, "pending");
        orders.put(orderCounter, order);
        return order;
    }
}
