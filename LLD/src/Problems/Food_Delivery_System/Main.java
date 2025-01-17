package Problems.Food_Delivery_System;

import Problems.Food_Delivery_System.Core_Classes.*;
import Problems.Food_Delivery_System.Core_Functionalities.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create Services
        RestaurantService restaurantService = new RestaurantService();
        OrderService orderService = new OrderService();

        // Create Users
        User user = new User(1, "John Doe", "123 Main St");

        // Create Restaurants and Menu Items
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(1, "Pizza", 10.99));
        menuItems.add(new MenuItem(2, "Burger", 7.99));

        Restaurant restaurant = new Restaurant(1, "Pizza Place", "Downtown", menuItems);
        restaurantService.addRestaurant(restaurant);

        // List Restaurants
        System.out.println("Available Restaurants:");
        for (Restaurant r : restaurantService.listRestaurants()) {
            System.out.println(r.getName());
        }

        // Place an Order
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(new OrderItem(menuItems.get(0), 2)); // 2 Pizzas

        Order order = orderService.placeOrder(user, restaurant, orderItems);
        System.out.println("Order Placed. Order ID: " + order.getOrderId());

        // Track Order
        OrderTrackingService trackingService = new OrderTrackingService(orderService.orders);
        System.out.println(trackingService.trackOrder(order.getOrderId()));
    }
}

