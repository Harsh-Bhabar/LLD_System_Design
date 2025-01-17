package Problems.Food_Delivery_System.Core_Classes;

import java.util.List;

public class Restaurant {
    private int restaurantId;
    private String name;
    private String location;
    private List<MenuItem> menuItems;

    public Restaurant(int restaurantId, String name, String location, List<MenuItem> menuItems) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.location = location;
        this.menuItems = menuItems;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
