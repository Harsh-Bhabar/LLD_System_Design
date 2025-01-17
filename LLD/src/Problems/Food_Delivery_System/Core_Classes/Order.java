package Problems.Food_Delivery_System.Core_Classes;

import java.util.List;

public class Order {
    private int orderId;
    private User user;
    private Restaurant restaurant;
    private List<OrderItem> items;
    private String status;

    public Order(int orderId, User user, Restaurant restaurant, List<OrderItem> items, String status) {
        this.orderId = orderId;
        this.user = user;
        this.restaurant = restaurant;
        this.items = items;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

