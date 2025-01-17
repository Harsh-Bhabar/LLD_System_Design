package Problems.Food_Delivery_System.Core_Functionalities;

import Problems.Food_Delivery_System.Core_Classes.*;

import java.util.*;

public class OrderTrackingService {
    private HashMap<Integer, Order> orders;

    public OrderTrackingService(HashMap<Integer, Order> orders) {
        this.orders = orders;
    }

    public String trackOrder(int orderId) {
        if (!orders.containsKey(orderId)) {
            return "Order not found.";
        }
        Order order = orders.get(orderId);
        return "Order Status: " + order.getStatus();
    }
}
